package com.example.dynamicitemrecyclerview.capabilities

import android.view.View
import com.example.dynamicitemrecyclerview.MainModel

interface DynamicCapabilitiesInterface {
    fun bindData(
        view: View,
        data: MainModel? = null
    )
}