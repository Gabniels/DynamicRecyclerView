package com.example.dynamicitemrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dynamicitemrecyclerview.capabilities.ButtonCapabilities
import com.example.dynamicitemrecyclerview.capabilities.DefaultCapabilities
import com.example.dynamicitemrecyclerview.capabilities.DynamicCapabilitiesInterface
import com.example.dynamicitemrecyclerview.capabilities.ImageViewCapabilities
import com.example.dynamicitemrecyclerview.capabilities.SwitchCapabilities
import com.example.dynamicitemrecyclerview.capabilities.TextViewCapabilities

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<MainModel>() {
        override fun areItemsTheSame(oldItem: MainModel, newItem: MainModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MainModel, newItem: MainModel): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    inner class ViewHolder(
        private val view: View, private val bindingStrategy: DynamicCapabilitiesInterface
    ) : RecyclerView.ViewHolder(view) {
        fun bindData(item: MainModel) {
            bindingStrategy.bindData(
                view = view, data = item
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mapping = mapOf(
            TextView to Pair(R.layout.item_textview_capabilities, TextViewCapabilities()),
            Button to Pair(R.layout.item_button_capabilities, ButtonCapabilities()),
            Switch to Pair(R.layout.item_switch_capabilities, SwitchCapabilities()),
            ImageView to Pair(R.layout.item_imageview_capabilities, ImageViewCapabilities())
        )

        val pair = mapping[viewType]

        return if (pair != null) {
            val (layoutResId, bindingStrategy) = pair
            val view = LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
            ViewHolder(view, bindingStrategy)
        } else {
            ViewHolder(
                View(parent.context), DefaultCapabilities()
            )
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = differ.currentList[position]
        return when (item.type) {
            "Textview" -> TextView
            "Button" -> Button
            "Switch" -> Switch
            "ImageView" -> ImageView
            else -> 0
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.bindData(item)

    }

    companion object {
        const val TextView = 1
        const val Button = 2
        const val Switch = 3
        const val ImageView = 4

    }
}