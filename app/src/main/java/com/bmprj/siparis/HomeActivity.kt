package com.bmprj.siparis

import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.bmprj.siparis.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var homeN:ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeN = DataBindingUtil.setContentView(this,R.layout.activity_home)
        homeN.homeNesnesi=this



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = resources.getColor(R.color.buton_1)
        }




        createViewPager()
        homeN.tabLayout.setupWithViewPager(homeN.viewPager)



        createTab()


    }

    fun createViewPager(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.FragmentElkle(ProductListFragment())
        adapter.FragmentElkle(DrinkListFragment())
        homeN.viewPager.adapter=adapter
    }

    internal class ViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager){
        private val fragmentList:MutableList<Fragment> = ArrayList()

        override fun getCount(): Int {
            return fragmentList.size
        }

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        fun FragmentElkle(fragment: Fragment){
            fragmentList.add(fragment)
        }

    }

    fun createTab(){
        homeN.tabLayout.getTabAt(0)?.setText("Foods")

        homeN.tabLayout.getTabAt(1)?.setText("Drinks")
    }



}

