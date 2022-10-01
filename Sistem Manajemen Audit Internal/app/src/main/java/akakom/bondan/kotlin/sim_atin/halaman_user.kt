package akakom.bondan.kotlin.sim_atin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class halaman_user : AppCompatActivity() {
    var username: TextView? = null
    var add: Button? = null
    var delet: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_halaman_user)
        val extras1 = intent.extras
        val intent = extras1!!.getString("userkey1")
        username = findViewById<View>(R.id.username) as TextView
        username!!.text = intent
    } /*
    Terimakasi Telah  Mampir di www.appank.com
    tetap belajar salam coding teman-teman
     */
}