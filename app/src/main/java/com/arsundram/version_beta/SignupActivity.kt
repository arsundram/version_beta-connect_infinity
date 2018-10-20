package com.arsundram.version_beta

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.signup.*
import kotlinx.android.synthetic.main.signup_page_new.*
import java.util.*
import kotlin.concurrent.schedule

class SignupActivity:AppCompatActivity(){

    lateinit var mProgressbar : ProgressDialog

    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.signup_page_new)
        super.onCreate(savedInstanceState)

        mAuth = FirebaseAuth.getInstance();
        mProgressbar = ProgressDialog(this)

        signupnewbackbutton.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        signupnew_Signupbutton.setOnClickListener {

            val email = emailidbox.text.toString().trim()
            val password = passwdbox.text.toString().trim()


            if (TextUtils.isEmpty(email)) {

                emailidbox.error = "Enter Email"
                return@setOnClickListener
            }
            if (TextUtils.isEmpty(password)) {

                passwdbox.error = "Enter Password"
                return@setOnClickListener
            }

            createUser(email, password)

//            Toast.makeText(this,"Successfully Created..! Now Login to your account.",Toast.LENGTH_LONG).show()
//            val intent=Intent(this@SignupActivity,MainActivity::class.java)
//            Timer().schedule(3000){  startActivity(intent)}
        }
        signup_login_button.setOnClickListener{
            val intent=Intent(this@SignupActivity,MainActivity::class.java)
            startActivity(intent)
        }
    }
    fun createUser( email: String, password: String) {

        mProgressbar.setMessage("Please wait..")
        mProgressbar.show()


        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {

                        val Intent = Intent(applicationContext, MainActivity::class.java)
                        startActivity(Intent)
                        finish()
                        mProgressbar.dismiss()

                    } else {

                        Toast.makeText(this, "Authentication failed.${task.exception}", Toast.LENGTH_SHORT).show()
                        mProgressbar.dismiss()

                    }
                }
}}