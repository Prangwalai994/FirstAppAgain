package com.example.firstappagain.Fragment

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = arrayOf(Add::class), version = 1, exportSchema = false)
abstract class AddRoomDatabase : RoomDatabase() {

    abstract fun addDao(): AddDao

    companion object {
        @Volatile
        private var INSTANCE: AddRoomDatabase? = null

        fun getDatabase(
            context:Context,
            scope:CoroutineScope
        ): AddRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AddRoomDatabase::class.java,
                    "word_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(UserDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private class UserDatabaseCallback(
            private val scope:CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onOpen(db:SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch {
                        populateDatabase(database.addDao())
                    }
                }
            }

            fun populateDatabase(userDao: AddDao) {
                userDao.deleteAll()
            }
        }
    }
}
