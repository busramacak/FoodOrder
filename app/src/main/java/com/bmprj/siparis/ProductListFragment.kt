package com.bmprj.siparis

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bmprj.siparis.databinding.FragmentProductListBinding

class ProductListFragment : Fragment() {
    private lateinit var listN : FragmentProductListBinding
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var adapter: RecyclerView.Adapter<HomeProductAdapter.ViewHolder>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        listN = DataBindingUtil.inflate(inflater,R.layout.fragment_product_list,container, false)
        listN.productListFragmentNesnesi=this


        return listN.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listN.recyclerHome.apply {
            layoutManager= GridLayoutManager(context,2)
            listN.recyclerHome.layoutManager=layoutManager

            adapter = HomeProductAdapter()
            listN.recyclerHome.adapter=adapter
        }
    }

}