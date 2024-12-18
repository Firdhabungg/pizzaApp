package com.example.pizzaapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaapp.response.FoodResponse
import com.squareup.picasso.Picasso

class AdapterMenu (private val listMenu:ArrayList<FoodResponse>):
        RecyclerView.Adapter<AdapterMenu.ViewHolder>() {

    inner class ViewHolder(v: View):RecyclerView.ViewHolder(v) {
        val imgFotoMenu : ImageView
        val textNamaMenu : TextView
        val textHargaMenu : TextView
        val btnAddMenu : TextView
        val context = v.context;

        init {
            imgFotoMenu = v.findViewById(R.id.imageViewMenu)
            textNamaMenu =  v.findViewById(R.id.textViewNamaMenu)
            textHargaMenu =  v.findViewById(R.id.textViewHargaMenu)
            btnAddMenu =  v.findViewById(R.id.textViewAddMenu)
        }
        fun bind(response: FoodResponse){
            //get response dari REST API
            val name = "${response.food_name}"
            val price = "${response.price}"
            val picture = "${response.food_picture}"
//            add data response ke TextView dan ImageView (cardView)
            textNamaMenu.text = name
            textHargaMenu.text = price
            val url = "http://192.168.123.37/rest_api3055/gambar/" + picture
            Picasso.get().load(url).into(imgFotoMenu)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterMenu.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.card_layout_home, parent, false)
        return ViewHolder(cellForRow)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listMenu[position])
    }

    override fun getItemCount(): Int {
        return listMenu.size
    }
}