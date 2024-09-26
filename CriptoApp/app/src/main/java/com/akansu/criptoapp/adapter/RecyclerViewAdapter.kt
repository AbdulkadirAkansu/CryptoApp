package com.akansu.criptoapp.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.akansu.criptoapp.R
import com.akansu.criptoapp.databinding.ActivityMainBinding
import com.akansu.criptoapp.databinding.RowLayoutBinding
import com.akansu.criptoapp.model.CryptoModel


class RecyclerViewAdapter(private val binding: ActivityMainBinding,private val cryptoList : ArrayList<CryptoModel>,private val listener: Listener): RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    interface Listener{
        fun onItemClick(cryptoModel: CryptoModel)
    }

    private var colors:Array<String> = arrayOf("#f21840","#088db0","#0047ab","#990000","#4bec13","#81d8d0","#ef8200","#a75ad0","#ff03c0")

    class RowHolder(private val binding: RowLayoutBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(cryptoModel: CryptoModel,colors:Array<String>,position: Int,listener: Listener){

            itemView.setOnClickListener{
                listener.onItemClick(cryptoModel)
            }
            itemView.setBackgroundColor(Color.parseColor(colors[position % 9]))

            binding.textName.text = cryptoModel.currency
            binding.textPrice.text = cryptoModel.price




            //itemView.text_name.text = cryptoModel.currency
            //itemView.text_price.text = cryptoModel.price
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
        return RowHolder(RowLayoutBinding.bind(view))

    }

    override fun getItemCount(): Int {

        return cryptoList.count()

    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position],colors,position,listener)
    }
}