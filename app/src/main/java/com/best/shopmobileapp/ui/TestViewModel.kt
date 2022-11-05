package com.best.shopmobileapp.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.best.domain.models.BestSellerProduct
import com.best.domain.models.ProductBasketInfo
import com.best.domain.usecase.ProductUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(
    private val productUseCases: ProductUseCases
): ViewModel() {
    fun init(){
        viewModelScope.launch {
            productUseCases.getDetailInfoForProduct.invoke().collect{
               Log.d("EEE",it.data.toString())
            }
        }
    }
}