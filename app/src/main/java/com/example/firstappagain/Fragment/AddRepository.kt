package com.example.firstappagain.Fragment

import androidx.lifecycle.LiveData

class AddRepository(private val addDao: AddDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allAdds: LiveData<List<Add>> = AddDao.getAlphabetizedAdds()


    suspend fun insert(add: Add) {
        addDao.insert(add)
    }
}
