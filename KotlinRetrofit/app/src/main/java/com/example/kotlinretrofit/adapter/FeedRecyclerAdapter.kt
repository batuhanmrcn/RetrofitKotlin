package com.example.kotlinretrofit.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinretrofit.databinding.RecyclerRowBinding
import com.example.kotlinretrofit.model.CryptoModel

class FeedRecyclerAdapter() : RecyclerView.Adapter<FeedRecyclerAdapter.RowHolder>() {
    private var cryptoList : ArrayList<CryptoModel> = arrayListOf()
   private var colors : ArrayList<String> = arrayListOf("#13bd27","#29c1e1","#b129e1","#d3df13","#f6bd0c","#a1fb93","#0d9de3","#ffe48f")


    class RowHolder(val binding : RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    fun setData(list : ArrayList<CryptoModel>?){
        list?.let {
            cryptoList = list
            notifyDataSetChanged()
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return RowHolder(binding)

    }

    override fun getItemCount(): Int {
        return cryptoList.size
        }
nuh
    override fun onBindViewHolder(holder: RowHolder, position: Int,) {
        holder.binding.textName.setTextColor(Color.parseColor(colors.get(position)))
        holder.binding.textName.text = cryptoList.get(position).currency
        holder.binding.textPrice.text = cryptoList.get(position).price
    }
}