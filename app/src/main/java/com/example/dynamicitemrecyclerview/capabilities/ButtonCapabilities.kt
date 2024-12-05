package com.example.dynamicitemrecyclerview.capabilities

import android.view.View
import com.example.dynamicitemrecyclerview.MainModel
import com.example.dynamicitemrecyclerview.databinding.ItemButtonCapabilitiesBinding

class ButtonCapabilities : DynamicCapabilitiesInterface {
    override fun bindData(view: View, data: MainModel?) {
        val binding = ItemButtonCapabilitiesBinding.bind(view)
        binding.button.text = data?.value ?: "-"
    }
}