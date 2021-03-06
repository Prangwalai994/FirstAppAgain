package com.example.firstappagain.Fragment

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface AddDao {

    @Query("SELECT * from add_table ORDER BY add ASC")
    fun getAlphabetizedAdds(): LiveData<List<Add>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(add: Add)

    @Query("DELETE FROM add_table")
    fun deleteAll()
}