package com.bmprj.siparis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.bmprj.siparis.databinding.FragmentDrinkListBinding

class DrinkListFragment : Fragment() {
    private lateinit var drinkN:FragmentDrinkListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        drinkN = DataBindingUtil.inflate(inflater,R.layout.fragment_drink_list, container, false)
        drinkN.drinksListFragmentNesnesi=this
        return drinkN.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var markalar = arrayOf("Dimen","CoolCola","Yakut","Spring","Yakut","Freş","Dimen",)
        var urunAdlari = arrayOf("1LT Karışık Meyve Suyu","2.5LT Kola","Türk Kahvesi","1LT Gazoz",
            "Latte","200ml Az Tuzlu Ayran","700ml Vişneli Meyvesuyu")
        var fiyatlar = arrayOf(19,23,15,18,22,11,14)
        var fotiler = arrayOf(R.drawable.karisik_meyvesuyu,R.drawable.kola,R.drawable.turk_kahvesi,
        R.drawable.gazoz,R.drawable.latte,R.drawable.ayran,R.drawable.visneli_meyvesuyu)


        drinkN.reyclerDrink.apply {
            layoutManager=GridLayoutManager(context,2)
            drinkN.reyclerDrink.layoutManager=layoutManager

            adapter = ProductAdapter(markalar,urunAdlari,fiyatlar,fotiler)
            drinkN.reyclerDrink.adapter=adapter
        }
    }
}

