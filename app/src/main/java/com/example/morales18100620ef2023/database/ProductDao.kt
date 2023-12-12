package com.example.morales18100620ef2023.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ProductDao {
    @Insert
    fun insert(productEntity: ProductEntity)
    @Update

    fun update(productEntity: ProductEntity)
    @Delete
    fun delete(productEntity: ProductEntity)
    @Query("SELECT * FROM product ORDER BY description")
    fun getProductOrderByDescription(): LiveData<List<ProductEntity>>
}