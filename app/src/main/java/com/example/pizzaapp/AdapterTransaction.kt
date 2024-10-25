package com.example.pizzaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterTransaction (private val listOrder:List<TransactionModel>) : RecyclerView.Adapter<AdapterTransaction.ViewHolderOrder>() {
    class ViewHolderOrder (v: View):RecyclerView.ViewHolder(v) {
        val imgFotoMenu : ImageView
        val textNamaMenu : TextView
        val textHargaMenu : TextView
        val btnLess : TextView
        val textQty : TextView
        val btnMore : TextView
        val context = v.context;

        init {
            imgFotoMenu = v.findViewById(R.id.imageMenu)
            textNamaMenu = v.findViewById(R.id.textNamaMenu)
            textHargaMenu = v.findViewById(R.id.textHargaMenu)
            textQty = v.findViewById(R.id.textQtyMenu)
            btnLess = v.findViewById(R.id.textLess)
            btnMore = v.findViewById(R.id.textMore)
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterTransaction.ViewHolderOrder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.card_layout_order, parent, false)

        return ViewHolderOrder(cellForRow)
    }

    override fun onBindViewHolder(holder: AdapterTransaction.ViewHolderOrder, position: Int) {
        val modelTrx = listOrder[position]
        holder.imgFotoMenu.setImageResource(modelTrx.gambarMenu)
        holder.textNamaMenu.text = modelTrx.namaMenu
        holder.textHargaMenu.text = modelTrx.harga.toString()
        holder.textQty.text = modelTrx.qty.toString()
    }

    override fun getItemCount(): Int {
        return listOrder.size
    }
}