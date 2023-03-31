package com.bmprj.siparis

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bmprj.siparis.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {

    private lateinit var signN : ActivitySignUpBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signN = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        signN.signUpNesnesi=this

        auth = Firebase.auth

    }


    fun signUpBtnClick(){

        val eMail = signN.edTxtEmailSignUp.text.toString()
        val passwrd = signN.edTxtPasswrdSignUp.text.toString()

        auth.createUserWithEmailAndPassword(eMail,passwrd)
            .addOnCompleteListener(this){task->
                if(task.isSuccessful){
                    Toast.makeText(this, "Authentication Succesful.",
                        Toast.LENGTH_SHORT).show()
                }
                else{
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                }
            }

    }
}