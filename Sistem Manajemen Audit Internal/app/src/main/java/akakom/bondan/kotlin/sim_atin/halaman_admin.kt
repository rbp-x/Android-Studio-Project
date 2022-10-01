package akakom.bondan.kotlin.sim_atin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


open class halaman_admin : AppCompatActivity() {
    private lateinit var username: TextView
    private lateinit var add: Button
    private lateinit var delet: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_admin)
        val extras1 = intent.extras
        val intent = extras1!!.getString("yourkit1")
        username = findViewById<View>(R.id.username) as TextView
        username!!.text = intent
        add = findViewById<View>(R.id.add) as Button
        add!!.setOnClickListener {
            val intent = Intent(this@halaman_admin, Register_User::class.java)
            startActivity(intent)
        }
        delet = findViewById<View>(R.id.delet) as Button
        delet!!.setOnClickListener {
            val intent = Intent(this@halaman_admin, delete_akun::class.java)
            startActivity(intent)
        }
    }
}