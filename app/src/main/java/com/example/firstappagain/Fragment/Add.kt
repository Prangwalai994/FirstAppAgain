package com.example.firstappagain.Fragment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

class Add {
    @Entity(tableName = "word_table")
    class Add(@PrimaryKey @ColumnInfo(name = "add") val add: String)
}