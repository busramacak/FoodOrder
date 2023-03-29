package com.bmprj.siparis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.databinding.DataBindingUtil
import com.bmprj.siparis.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var main : ActivityMainBinding
    var tamamlandi=false
    var sureDoldu=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = DataBindingUtil.setContentView(this,R.layout.activity_main)
        main.mainNesnesi=this

        Handler().postDelayed({
            if(tamamlandi){
                main.tanitimEkrani.visibility= View.GONE
                main.signinBtn.visibility=View.VISIBLE
                main.loginBtn.visibility=View.VISIBLE
            }
            else{

                sureDoldu=true
            }

        },3000)

        tanitimEkraniBaslat()

    }

    fun tanitimEkraniBaslat(){

        Handler().postDelayed({
            if(sureDoldu){
                main.tanitimEkrani.visibility = View.GONE

            }
            else{
                tamamlandi=true
            }
        },1000)
    }


    fun loginClick(){

    }

    fun signInClick(){

    }
}