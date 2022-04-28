package com.example.myapplicationtest11.presentation.main

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationtest11.R
import com.example.myapplicationtest11.data.remote.model.User
import com.example.myapplicationtest11.databinding.ActivityItemBinding

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>(){

    private val items = mutableListOf<User>()

    inner class MainViewHolder(private val binding: ActivityItemBinding):
        RecyclerView.ViewHolder(binding.root){

            fun bind(user: User) {
                binding.name.text = user.toString()
                binding.executePendingBindings()
            }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding: ActivityItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.activity_item,parent,false
        )
        return MainViewHolder(binding).apply {
            binding.root.setOnClickListener { view ->
                val position = adapterPosition.takeIf {
                    it != RecyclerView.NO_POSITION
                } ?: return@setOnClickListener
            }
        }
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun addData(items: List<User>){
        this.items.clear()
        this.items.addAll(items)

        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return items.size
    }
}