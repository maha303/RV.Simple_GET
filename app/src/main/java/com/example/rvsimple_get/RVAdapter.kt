package com.example.rvsimple_get

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class RVAdapter(private val items: ArrayList<MyDataItem>) :RecyclerView.Adapter<RVAdapter.ItemsViewHolder>(){
    class ItemsViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        return ItemsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false))
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
       val item = items[position]
        holder.itemView.apply {
            tvName.text=item.name

        }
    }

    override fun getItemCount()=items.size
}