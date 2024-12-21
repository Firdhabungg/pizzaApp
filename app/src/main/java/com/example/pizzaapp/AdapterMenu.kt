package com.example.pizzaapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.pizzaapp.client.RetrofitClient
import com.example.pizzaapp.response.FoodResponse
import com.squareup.picasso.Picasso

class AdapterMenu (private val listMenu:ArrayList<FoodResponse>):
        RecyclerView.Adapter<AdapterMenu.ViewHolder>() {

    inner class ViewHolder(v: View):RecyclerView.ViewHolder(v) {
        val txtIdMenu : TextView = v.findViewById(R.id.textViewIdMenu)
        val imgFotoMenu : ImageView = v.findViewById(R.id.imageViewMenu)
        val textNamaMenu : TextView = v.findViewById(R.id.textViewNamaMenu)
        val textHargaMenu : TextView = v.findViewById(R.id.textViewHargaMenu)
        val btnAddMenu : TextView = v.findViewById(R.id.textViewAddMenu)
        val context: Context? = v.context
        val cardMenu : CardView = v.findViewById(R.id.card_display_menu)

        fun bind(response: FoodResponse){
            //get response dari REST API
            val id:String = "${response.food_id}"
            val name = "${response.food_name}"
            val price = "${response.price}"
            val picture = "${response.food_picture}"

//            add data response ke TextView dan ImageView (cardView)
            txtIdMenu.text = id
            textNamaMenu.text = name
            textHargaMenu.text = price
            val url = RetrofitClient.url + picture
            Picasso.get().load(url).into(imgFotoMenu)

            cardMenu.setOnClickListener {
                var cek = 0
                var result = false
                AdapterTransaction.amount = AdapterTransaction.listId.count()
                if(AdapterTransaction.listId.count() == 0){
                    AdapterTransaction.listId += id
                    AdapterTransaction.listName += name
                    AdapterTransaction.listPrice += price.toString().toInt()
                    AdapterTransaction.listPicture += picture
                    AdapterTransaction.listQty += 1
                    AdapterTransaction.price = AdapterTransaction.price + price.toString().toInt()
                }else {
                    while (cek < AdapterTransaction.listId.count()) {
                        if (AdapterTransaction.listId[cek] == id) {
                            result = false
                            break
                        }else {
                            result = true
                        }
                        cek++
                    }
                    if (result == true) {
                        Toast.makeText(context, "ID Menu belum ada", Toast.LENGTH_SHORT).show()
                        AdapterTransaction.listId += id
                        AdapterTransaction.listName += name
                        AdapterTransaction.listPrice += price.toString().toInt()
                        AdapterTransaction.listPicture += picture
                        AdapterTransaction.listQty += 1
                        AdapterTransaction.price = AdapterTransaction.price + price.toString().toInt()
                    } else {
                        Toast.makeText(context, "ID Menu sudah ada", Toast.LENGTH_SHORT).show()
                        AdapterTransaction.listQty[cek] += 1
                    }
                }
            }
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