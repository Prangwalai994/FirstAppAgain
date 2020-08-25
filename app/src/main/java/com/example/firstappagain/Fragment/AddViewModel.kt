package com.example.firstappagain.Fragment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddViewModel(application:Application) : AndroidViewModel(application) {

    private val repository: AddRepository

    val allAdds:LiveData<List<Add>>

    init {
        val addsDao = AddRoomDatabase.getDatabase(application, viewModelScope).addDao()

        repository = AddRepository(addsDao)
        allAdds = repository.allAdds
    }


    fun insert(add:Add) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(add)
    }
}