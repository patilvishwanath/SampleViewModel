package com.vp.sampleviewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Vishwanath Patil on 22/09/20.
 */
class SampleViewModel : ViewModel() {

   private val _liveData = MutableLiveData<Int>()

    val liveData : LiveData<Int> = _liveData

    init {
        Log.v("TAG","SampleVieModel created")
        _liveData.value = 0
    }

    fun increment(){
        _liveData.value = _liveData.value!! + 1
    }

    fun decrement(){
        _liveData.value = _liveData.value!! - 1

    }

    override fun onCleared() {
        super.onCleared()
        Log.v("TAG","SampleVieModel cleared")
    }

}