package com.bmprj.siparis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bmprj.siparis.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {


    private lateinit var main : ActivityMainBinding
    var tamamlandi=false
    var sureDoldu=false

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        main = DataBindingUtil.setContentView(this,R.layout.activity_main)
        main.mainNesnesi=this
        auth = Firebase.auth

        Handler().postDelayed({
            if(tamamlandi){
                main.tanitimEkrani.visibility= View.GONE
                main.signUpBtn.visibility=View.VISIBLE
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


        val eMail = main.edTxtEmail.text.toString()
        val passwrd = main.edTxtPasswrd.text.toString()


        auth.signInWithEmailAndPassword(eMail,passwrd)
            .addOnCompleteListener(this){task->
                if(task.isSuccessful){
                    Toast.makeText(baseContext, "Authentication succes.",
                        Toast.LENGTH_SHORT).show()

                }
                else{
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    fun signUpClick(){
        startActivity(Intent(this,SignUpActivity::class.java))
    }
}