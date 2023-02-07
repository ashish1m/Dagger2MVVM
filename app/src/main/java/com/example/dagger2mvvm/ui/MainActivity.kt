package com.example.dagger2mvvm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger2mvvm.Dagger2MVVMApp
import com.example.dagger2mvvm.databinding.ActivityMainBinding
import com.example.dagger2mvvm.viewmodel.MainViewModel
import com.example.dagger2mvvm.viewmodel.MainViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel
    private lateinit var productAdapter: ProductAdapter

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        productAdapter = ProductAdapter()

        Dagger2MVVMApp.mInstance.applicationComponent.inject(this)
        mainViewModel = ViewModelProvider(this, mainViewModelFactory)[MainViewModel::class.java]

        initView()
        setProductObserver()
    }

    private fun initView() {
        binding.rvProducts.layoutManager = LinearLayoutManager(this)
        binding.rvProducts.setHasFixedSize(true)
        binding.rvProducts.adapter = productAdapter
    }

    private fun setProductObserver() {
        mainViewModel.productsLiveData.observe(this) { productList ->
            productList?.let {
                productAdapter.updateProductList(it)
            }
        }
    }
}