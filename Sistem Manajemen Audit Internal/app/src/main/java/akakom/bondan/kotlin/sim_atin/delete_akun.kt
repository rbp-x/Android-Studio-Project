package akakom.bondan.kotlin.sim_atin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class delete_akun : AppCompatActivity() {
    var mTextUsername: EditText?=null
    var mTextPassword: EditText?=null
    var mTextCnfPassword: EditText?=null
    var txt_namalengkap: EditText?=null
    var add: Button?=null
    var close: Button?=null
    var db: DatabaseHelper?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_akun)
        db=DatabaseHelper(this)
        txt_namalengkap=findViewById(R.id.edittext_nama)
        mTextUsername=findViewById(R.id.edittext_username)
        mTextPassword=findViewById<View>(R.id.edittext_password) as EditText
        mTextCnfPassword=findViewById(R.id.edittext_cinfir_pasword)
        add=findViewById<View>(R.id.add) as Button
        close=findViewById<View>(R.id.exit) as Button
        close!!.setOnClickListener { finish() }
        add!!.setOnClickListener {
            val user = mTextUsername!!.getText().toString().trim { it <= ' ' }
            val pwd = mTextCnfPassword!!.text.toString().trim { it <= ' ' }
            val cnf_pwd = mTextCnfPassword!!.getText().toString().trim { it <= ' ' }
            val nama = txt_namalengkap!!.getText().toString().trim { it <= ' ' }
            val res = db!!.delet(user, pwd)
            if (res == false) {
                Toast.makeText(this@delete_akun,
                    "Berhasil Menghapus User  $nama",
                    Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@delete_akun, "Gagal Menghapus User  $nama", Toast.LENGTH_SHORT)
                    .show()
            }
            if (nama == "" || user == "" || pwd == "" || cnf_pwd == "") {
                Toast.makeText(this@delete_akun, "Data Tidak Boleh Kosong", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}