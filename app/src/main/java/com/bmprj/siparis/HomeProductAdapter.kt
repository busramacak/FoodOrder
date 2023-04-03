package com.bmprj.siparis

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.firebase.ktx.Firebase

class HomeProductAdapter() : RecyclerView.Adapter<HomeProductAdapter.ViewHolder>() {

    var markalar = arrayOf("Dominto","Burgerim","Acıktım","Acıktım","Pilavcı Mehmet")
    var urunAdlari = arrayOf("Karışık Pizza","Double Burger","Ekmek Döner","Hatay Usulü Dürüm","Nohutlu Tavuk Pilav")
    var fiyatlar = arrayOf(47,56,25,30,20)
    var fotiler = arrayOf(R.drawable.karisik_pizza,R.drawable.hamburger,R.drawable.ekmek_doner,
        R.drawable.hatay_usulu_doner,R.drawable.nohutlu_tavuk_pilav)


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