package com.example.dynamicitemrecyclerview.capabilities

import android.util.Log
import android.view.View
import coil.load
import com.example.dynamicitemrecyclerview.MainModel
import com.example.dynamicitemrecyclerview.databinding.ItemImageviewCapabilitiesBinding

class ImageViewCapabilities: DynamicCapabilitiesInterface {
    override fun bindData(view: View, data: MainModel?) {
        val binding = ItemImageviewCapabilitiesBinding.bind(view)
        binding.imageView.load(data)
    }
}