package com.example.dynamicitemrecyclerview.capabilities

import android.view.View
import com.example.dynamicitemrecyclerview.MainModel
import com.example.dynamicitemrecyclerview.databinding.ItemSwitchCapabilitiesBinding

class SwitchCapabilities: DynamicCapabilitiesInterface {
    override fun bindData(view: View, data: MainModel?) {
        val binding = ItemSwitchCapabilitiesBinding.bind(view)

    }
}