package com.example.dagger2mvvm.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dagger2mvvm.R
import com.example.dagger2mvvm.databinding.LayoutProductItemBinding
import com.example.dagger2mvvm.model.Product

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    private val productList = mutableListOf<Product>()

    fun updateProductList(productList: List<Product>) {
        this.productList.clear()
        this.productList.addAll(productList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_product_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]
        holder.binding.tvTitle.text = product.title
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = LayoutProductItemBinding.bind(itemView)
    }
}