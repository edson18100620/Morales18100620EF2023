package com.example.morales18100620ef2023.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("product")
data class ProductEntity(
    @ColumnInfo("id") var id: String?,
    @ColumnInfo("description") var description: String?,
    @ColumnInfo("price") var price: String?
){
    @PrimaryKey(true)
    @ColumnInfo("product_id") var productId: Int = 0
}
