package com.vkram2711.animevost.activitys

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import com.vkram2711.animevost.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userInterfaceInit()
    }

    private fun userInterfaceInit(){
        Navigation.findNavController(this, R.id.nav_host).navigate(R.id.action_flowFragment_to_ongoingFragment)
    }
}
