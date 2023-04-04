package com.bmprj.siparis
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

val rnds = (10..20).random()

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
        var itemSiparis:TextView

        init{

            itemImg = itemView.findViewById(R.id.urunImg)
            itemMarka = itemView.findViewById(R.id.markaAdi)
            itemUrunAd = itemView.findViewById(R.id.urunadi)
            itemFiyat = itemView.findViewById(R.id.urunFiyati)
            itemSiparis = itemView.findViewById(R.id.siparisVer)


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



        holder.itemSiparis.setOnClickListener(View.OnClickListener {

            val builder = AlertDialog.Builder(it.context)
            builder.setTitle(Html.fromHtml("<font color='#757474' size='10'>Sipariş Bilgisi</font>"))
            builder.setMessage("\n"+rnds.toString()+" "+Html.fromHtml("<font color='#757474'>Numaralı masa için siparişiniz oluşturuldu.\n En kısa sürede teslim edilecektir..</font>"))
            builder.setPositiveButton(
                Html.fromHtml("<font color='#805BBC'>TAMAM</font>")
            ){ dialog, arg1 -> dialog.cancel() }
            val alert = builder.create()
            alert.show()
        })

    }


}


