package com.example.firstappagain.Fragment

import androidx.lifecycle.LiveData

class AddRepository(private val addDao: AddDao) {

    val allAdds:LiveData<List<Add>> = addDao.getAlphabetizedAdds()

    fun insert(add:Add) {
        addDao.insert(add)
    }
}