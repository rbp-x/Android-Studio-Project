@file:Suppress("ImplicitThis")

package akakom.bondan.kotlin.sim_atin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var username: EditText? = null
    var password: EditText? = null
    var btnLogin: Button? = null
    var exit: Button? = null
    var db: DatabaseHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        db = DatabaseHelper(this)
        username = findViewById<View>(R.id.username) as EditText
        password = findViewById<View>(R.id.password) as EditText
        btnLogin = findViewById<View>(R.id.login) as Button
        exit = findViewById<View>(R.id.exit) as Button
        exit!!.setOnClickListener { finish() }
        btnLogin!!.setOnClickListener {
            val usernameKey = username!!.text.toString()
            val passwordKey = password!!.text.toString()
            val res = db!!.periksaUser(usernameKey, passwordKey)
            if (usernameKey == "bondan" && passwordKey == "123") {
                //jika login berhasil
                Toast.makeText(applicationContext, "Selamat Datang Admin $usernameKey",
                    Toast.LENGTH_SHORT).show()
                startActivityForResult(Intent(this, halaman_admin::class.java), REQUEST_CODE)
                val value = username!!.text.toString()
                intent.putExtra("yourkey1", value)
                startActivityForResult(intent, REQUEST_CODE)
            } else if (res == true) {
                //jika gagal maka akan menjalangkan pojek di bawah
                val moveToHome = Intent(this@MainActivity, halaman_user::class.java)
                startActivity(moveToHome);
                // Data username di ambil menuju ke activity2
                val value = username!!.text.toString()
                with(moveToHome) {
                    putExtra("userkey1", value)
                }
                startActivityForResult(moveToHome, REQUEST_CODE)
                Toast.makeText(this.applicationContext,
                    "Selamat Datang User $usernameKey", Toast.LENGTH_SHORT).show()
            } else {
                //jika login gagal
                val builder = AlertDialog.Builder(this@MainActivity)
                builder.setMessage("Username atau Password Anda salah!")
                    .setNegativeButton("Retry", null).create().show()
            }
        }
    }

    companion object {
        private const val REQUEST_CODE = 10
    }
}