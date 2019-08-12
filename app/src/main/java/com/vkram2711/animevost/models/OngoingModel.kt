package com.vkram2711.animevost.models

import android.util.Log
import com.vkram2711.animevost.api.API
import com.vkram2711.animevost.pojo.Ongoing
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

class OngoingModel {
    private val TAG = this::class.java.simpleName

    fun refreshData(onDataReadyCallback: OnDataReadyCallback, page: Int) {
        val service = API.create()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getOngoings(1)

            withContext(Dispatchers.Main) {
                try {
                    if (response.isSuccessful) {
                        response.body().let { onDataReadyCallback.onDataReady(it!!) }
                    } else {
                        Log.d(TAG, "Error: ${response.code()}")
                    }
                } catch (e: HttpException) {
                    e.printStackTrace()
                }
            }
        }
    }

    interface OnDataReadyCallback {
        fun onDataReady(data : Ongoing)
    }
}