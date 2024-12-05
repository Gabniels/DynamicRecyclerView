package com.example.dynamicitemrecyclerview.capabilities

import android.view.View
import com.example.dynamicitemrecyclerview.MainModel
import com.example.dynamicitemrecyclerview.databinding.ItemTextviewCapabilitiesBinding

class TextViewCapabilities : DynamicCapabilitiesInterface {
    override fun bindData(view: View, data: MainModel?) {
        val binding = ItemTextviewCapabilitiesBinding.bind(view)
        binding.textView.text = data?.value ?: "-"
    }

}