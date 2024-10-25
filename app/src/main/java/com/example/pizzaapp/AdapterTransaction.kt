package com.example.pizzaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterTransaction (private val listOrder:List<TransactionModel>):
    RecyclerView.Adapter<AdapterTransaction.ViewHolderOrder>() {
    class ViewHolderOrder (v: View):RecyclerView.ViewHolder(v){
    val imgFotoMenu : ImageView = v.findViewById(R.id.imageViewMenu)
        val textNamaMenu : TextView = v.findViewById(R.id.textNamaMenu)
        val textHargaMenu : TextView = v.findViewById(R.id.textHargaMenu)
        private val btnLess: TextView = v.findViewById(R.id.textLess)
        val textQty: TextView = v.findViewById(R.id.textQtyMenu)
        private val btnMore: TextView = v.findViewById(R.id.textMore)
        val context = v.context;

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterTransaction.ViewHolderOrder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.card_layout_order, parent, false)
        return  ViewHolderOrder(cellForRow)
    }
//detail view dari card_layout_order yang disesuaikan posisinya seperti posisi di index 0 maka dicari di index ke 0
    override fun onBindViewHolder(holder: AdapterTransaction.ViewHolderOrder, position: Int) {
        val modelTrx = listOrder[position]
        holder.imgFotoMenu.setImageResource(modelTrx.gambarMenu)
        holder.textNamaMenu.text = modelTrx.namaMenu
        holder.textHargaMenu.text = modelTrx.hargaMenu.toString()
        holder.textQty.text = modelTrx.qtyMenu.toString()
    }

    override fun getItemCount(): Int {
        return listOrder.size
    }

}