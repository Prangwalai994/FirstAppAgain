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

    abstract fun wordDao(): AddDao

    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var wordDao = database.wordDao()

                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: AddRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): AddRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AddRoomDatabase::class.java,
                    "add_database"
                )
                    .addCallback(AddDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}