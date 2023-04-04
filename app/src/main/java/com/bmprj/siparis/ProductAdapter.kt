package com.bmprj.siparis

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.coroutines.coroutineContext

class ProductAdapter(
     markalar : Array<String>,
     urunAdlari : Array<String>,
     fiyatlar : Array<Int>,
     fotiler : Array<Int>
)  : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    var markalar =markalar
    var urunAdlari =urunAdlari
    var fiyatlar = fiyatlar
    var fotiler = fotiler
    inner class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var itemImg :ImageView
        var itemMarka:TextView
        var itemUrunAd:TextView
        var itemFiyat:TextView

        init{
            itemImg = itemView.findViewById(R.id.urunImg)
            itemMarka = itemView.findViewById(R.id.markaAdi)
            itemUrunAd = itemView.findViewById(R.id.urunadi)
            itemFiyat = itemView.findViewById(R.id.urunFiyati)
        }
    }


    fun cardVClick() {


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item_layout, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return urunAdlari.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemMarka.text=markalar[position]
        holder.itemUrunAd.text=urunAdlari[position]
        holder.itemFiyat.text=fiyatlar[position].toString()
        holder.itemImg.setImageResource(fotiler[position])

    }


}