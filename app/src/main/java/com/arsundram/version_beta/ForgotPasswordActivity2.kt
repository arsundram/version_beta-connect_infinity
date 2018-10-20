package com.arsundram.version_beta

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.forgotpassword.*
import java.util.*
import kotlin.concurrent.schedule
import kotlinx.android.synthetic.main.resetpassword2.*

class ForgotPasswordActivity2:AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resetpassword2)

        resetpassword2backbutton2.setOnClickListener{
            val intent=Intent(this,ForgotPasswordActivity::class.java)
            startActivity(intent)
        }
        finalreset.setOnClickListener {

            Toast.makeText(this,"Successfully Created..! Now Login to your account.", Toast.LENGTH_LONG).show()
            val intent=Intent(this,MainActivity::class.java)
//            Handler().postDelayed({
//
//            },50000)
            Timer().schedule(3000){  startActivity(intent)}


        }
    }
}