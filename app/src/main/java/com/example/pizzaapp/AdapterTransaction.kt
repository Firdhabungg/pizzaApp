package com.example.pizzaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaapp.client.RetrofitClient
import com.squareup.picasso.Picasso

class AdapterTransaction(order: ArrayList<TransactionModel>) : RecyclerView.Adapter<AdapterTransaction.ViewHolderOrder>() {
    class ViewHolderOrder (v: View):RecyclerView.ViewHolder(v) {
        val imgFotoMenu : ImageView = v.findViewById(R.id.imageMenu)
        val textNamaMenu : TextView = v.findViewById(R.id.textNamaMenu)
        val textHargaMenu : TextView = v.findViewById(R.id.textHargaMenu)
        val idMenu : TextView = v.findViewById(R.id.textIdMenu)
        val btnLess : TextView = v.findViewById(R.id.textLess)
        val textQty : TextView = v.findViewById(R.id.textQtyMenu)
        val btnMore : TextView = v.findViewById(R.id.textMore)
        val context = v.context;

    }

    companion object {
        var amount:Int = 0
        var listId = mutableListOf<String>()
        var listName = mutableListOf<String>()
        var listPrice = mutableListOf<Int>()
        var listPicture = mutableListOf<String>()
        var listQty = mutableListOf<Int>()
        var price: Int = 0
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterTransaction.ViewHolderOrder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val cellForRow = layoutInflater.inflate(R.layout.card_layout_order, parent, false)

        return ViewHolderOrder(cellForRow)
    }

    override fun onBindViewHolder(holder: ViewHolderOrder, position: Int) {
        holder.idMenu.text = listId[position]
        holder.textNamaMenu.text = listName[position]
        holder.textHargaMenu.text = listPrice[position].toString()
        holder.textQty.text = listQty[position].toString()
        var url = RetrofitClient.url + listPicture[position]
        Picasso.get().load(url).into(holder.imgFotoMenu)
    }

    override fun getItemCount(): Int {
        return listId.size
    }
}