package akakom.bondan.kotlin.simatin

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class Welcome : AppCompatActivity() {
    var btnExit: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome)
        btnExit = findViewById<View>(R.id.btnExit) as Button
        btnExit!!.setOnClickListener {
            finish()
        }
    }
}