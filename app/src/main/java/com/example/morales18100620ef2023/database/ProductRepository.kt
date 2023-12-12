package com.example.morales18100620ef2023.database

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class ProductRepository(application:Application){

    private val productDao:
            ProductDao? = ProductDatabase
        .getInstance(application)?.customerDao()
    fun insert(customerEntity: ProductEntity){
        if(productDao!=null) {
            InsertAsyncTask(productDao).execute(customerEntity)
        }
    }
    fun getCustomers(): LiveData<List<ProductEntity>> {
        return productDao?.getProductOrderByDescription() ?: MutableLiveData<List<ProductEntity>>().apply{
            value = emptyList()
        }
    }

    private class InsertAsyncTask
        (private val customerDao: ProductDao): AsyncTask<ProductEntity, Void, Void>(){
        override fun doInBackground(vararg customers: ProductEntity?): Void? {
            for(customer in customers){
                if(customer!=null)
                    customerDao.insert(customer)
            }
            return null
        }
    }
}