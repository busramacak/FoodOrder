package com.bmprj.siparis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.bmprj.siparis.databinding.FragmentProductListBinding

class ProductListFragment : Fragment() {
    private lateinit var productN : FragmentProductListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        productN = DataBindingUtil.inflate(inflater,R.layout.fragment_product_list,container, false)
        productN.productListFragmentNesnesi=this


        return productN.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var markalar = arrayOf("Dominto","Burgerim","Acıktım","Acıktım","Pilavcı Mehmet")
        var urunAdlari = arrayOf("Karışık Pizza","Double Burger","Ekmek Döner","Hatay Usulü Dürüm","Nohutlu Tavuk Pilav")
        var fiyatlar = arrayOf(47,56,25,30,20)
        var fotiler = arrayOf(R.drawable.karisik_pizza,R.drawable.hamburger,R.drawable.ekmek_doner,
            R.drawable.hatay_usulu_doner,R.drawable.nohutlu_tavuk_pilav)


        productN.recyclerHome.apply {
            layoutManager= GridLayoutManager(context,2)
            productN.recyclerHome.layoutManager=layoutManager

            adapter = ProductAdapter(markalar,urunAdlari, fiyatlar,fotiler)
            productN.recyclerHome.adapter=adapter
        }
    }

}