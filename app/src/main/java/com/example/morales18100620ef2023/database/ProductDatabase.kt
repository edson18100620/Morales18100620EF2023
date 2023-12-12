package com.example.morales18100620ef2023.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities= [ProductEntity::class], version = 1)
abstract class ProductDatabase: RoomDatabase(){
    abstract fun customerDao(): ProductDao

    companion object {
        private const val DATABASE_NAME = "sales"
        @Volatile
        private var INSTANCE: ProductDatabase?=null

        fun getInstance(context: Context): ProductDatabase?{
            INSTANCE?: synchronized(this){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    ProductDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE
        }
    }

}