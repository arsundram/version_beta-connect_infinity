package com.arsundram.version_beta

import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.login_page_new.*

class MainActivity : AppCompatActivity() {
    lateinit var mProgressbar : ProgressDialog

    lateinit var mAuth  : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {

        mProgressbar = ProgressDialog(this)

        mAuth = FirebaseAuth.getInstance()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page_new)

        signupbutton.setOnClickListener {
            val intent = Intent(this@MainActivity, SignupActivity::class.java)
            startActivity(intent)
            finish()
        }
        forgotPasswordTextView.setOnClickListener {
            val intent = Intent(this@MainActivity, ForgotPasswordActivity::class.java)
            startActivity(intent)

        }
        loginButton.setOnClickListener {


            val email = emailbox.text.toString().trim()
            val password = passwordbox.text.toString().trim()

            if (TextUtils.isEmpty(email)) {
                emailbox.error = " Enter Email"
                return@setOnClickListener

            }
            loginUser(email , password)
        }
    }
    private fun loginUser(email: String, password: String) {
        mProgressbar.setMessage("Please wait..")
        mProgressbar.show()

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        mProgressbar.dismiss()
                        val startIntent  = Intent(applicationContext , HomePage::class.java)
                        startActivity(startIntent)
                        finish()
                    } else {

                        Toast.makeText(this, "Authentication failed.${task.exception}", Toast.LENGTH_SHORT).show()

                    }

                    mProgressbar.dismiss()
                }
    }
}