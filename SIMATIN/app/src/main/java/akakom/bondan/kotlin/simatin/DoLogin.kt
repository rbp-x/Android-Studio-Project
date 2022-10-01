@file:Suppress("ExplicitThis")

package akakom.bondan.kotlin.simatin

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button as Button1



class DoLogin : AppCompatActivity() {
    var username: EditText? = null
    var password: EditText? = null
    var btnLogin: Button1? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome)
        username = this.findViewById<View>(R.id.txt_username) as EditText
        password = this.findViewById<View>(R.id.txt_password) as EditText
        btnLogin = this.findViewById<View>(R.id.btn_login) as Button1
        btnLogin!!.setOnClickListener {
            val usernameKey = username!!.text.toString()
            val passwordKey = password!!.text.toString()
            if (usernameKey == "admin" && passwordKey == "1234") {
                //jika login berhasil
                Toast.makeText(applicationContext, "LOGIN SUKSES",
                    Toast.LENGTH_SHORT).show()
                val intent = Intent(this@DoLogin, Welcome::class.java)
                this@DoLogin.startActivity(intent)
                finish()
            } else {
                //jika login gagal
                val builder: AlertDialog.Builder =
                    AlertDialog.Builder(this@DoLogin)
                builder.setMessage("Username atau Password Anda salah!")
                    .setNegativeButton("Retry", null).create().show()
            }
        }
    }
}