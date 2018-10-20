package com.arsundram.version_beta

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.forgotpassword.*

class ForgotPasswordActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forgotpassword)
        resetpasswordbackbutton1.setOnClickListener {
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        VerifyOTPButton.setOnClickListener{
            val intent=Intent(this@ForgotPasswordActivity,ForgotPasswordActivity2::class.java)
            startActivity(intent)
        }


        sendotpbutton.setOnClickListener {
            VerifyOTPButton.isClickable=true


        }


        signin_lbutton_forgot1.setOnClickListener {
            val intent=Intent(this@ForgotPasswordActivity,MainActivity::class.java)
            startActivity(intent)
        }

    }
}
