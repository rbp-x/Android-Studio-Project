package akakom.bondan.kotlin.sim_atin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Register_User : AppCompatActivity() {
    var mTextUsername: EditText? = null
    var mTextPassword: EditText? = null
    var mTextCnfPassword: EditText? = null
    var txt_namalengkap: EditText? = null
    var add: Button? = null
    var close: Button? = null
    var db: DatabaseHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_register)
        this.db = DatabaseHelper(this)
        this.txt_namalengkap = this.findViewById(R.id.edittext_nama)
        this.mTextUsername = this.findViewById(R.id.edittext_username)
        this.mTextPassword = this.findViewById<View>(R.id.edittext_password) as EditText
        this.mTextCnfPassword = this.findViewById(R.id.edittext_cinfir_pasword)
        this.add = this.findViewById<View>(R.id.add) as Button
        this.close = this.findViewById<View>(R.id.exit) as Button
        this.close!!.setOnClickListener { this.finish() }
        this.add!!.setOnClickListener { it: View? ->
            val user = mTextUsername!!.getText().toString().trim { it <= ' ' }
            val pwd = mTextCnfPassword!!.text.toString().trim { it <= ' ' }
            val cnf_pwd = mTextCnfPassword!!.getText().toString().trim { it <= ' ' }
            val nama = txt_namalengkap!!.getText().toString().trim { it <= ' ' }
            if (pwd == cnf_pwd) {
                val `val` = this.db!!.tambahUser(user, pwd)
                if (`val` > 0) {
                    Toast.makeText(this@Register_User,
                        "Anda Berhasil menambahkan user $nama", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@Register_User,
                        "Anda gagal Registrasi user$nama",
                        Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this@Register_User, "Password tidak sama", Toast.LENGTH_SHORT).show()
            }
            if (nama == "" || user == "" || pwd == "") {
                Toast.makeText(this@Register_User, "Data Tidak Boleh Kosong", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}