package com.vkram2711.animevost.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vkram2711.animevost.models.OngoingModel
import com.vkram2711.animevost.pojo.Ongoing

class OngoingViewModel : ViewModel(){
    var ongoingModel: OngoingModel = OngoingModel()
    var isLoading = MutableLiveData<Boolean>()
    var data = MutableLiveData<Ongoing>()
    fun refresh(){
        ongoingModel.refreshData( object : OngoingModel.OnDataReadyCallback {
            override fun onDataReady(data: Ongoing) {
                this@OngoingViewModel.data.value = data
                isLoading.value = false
            }
        }, 1)
    }
}