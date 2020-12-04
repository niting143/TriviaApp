package com.arraigntech.triviaapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.arraigntech.triviaapp.data.Questionaire
import com.arraigntech.triviaapp.databinding.ItemLayoutBinding

public class ItemAdapter(private var itemList: List<Questionaire>) :
    RecyclerView.Adapter<ItemAdapter.Holder>() {


    class Holder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: List<Questionaire>) {
            binding.lists = item.get(adapterPosition)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutBinding.inflate(inflater)
        return Holder(
            binding
        )
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(itemList)
    }

}