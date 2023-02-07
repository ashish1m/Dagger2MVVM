package com.example.dagger2mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.dagger2mvvm.utils.Constants
import javax.inject.Inject

class SecondaryViewModel @Inject constructor(): ViewModel() {

    init {
        Log.d(Constants.TAG, "SecondaryViewModel initialised")
    }
}