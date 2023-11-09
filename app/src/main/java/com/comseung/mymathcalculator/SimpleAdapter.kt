package com.comseung.mymathcalculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.comseung.mymathcalculator.databinding.SimpleAdapterItemBinding

class SimpleAdapter(
    private val items: List<SimpleAdapterItem>
): RecyclerView.Adapter<SimpleAdapter.ViewHolder>(){

    class ViewHolder(private val binding: SimpleAdapterItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SimpleAdapterItem) {
            binding.functionName.text = item.functionName
            binding.functionName.setOnClickListener {
                it.findNavController().navigate(item.action)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SimpleAdapterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }
}