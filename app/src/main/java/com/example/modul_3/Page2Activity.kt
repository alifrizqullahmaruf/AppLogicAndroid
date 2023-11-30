package com.example.modul_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.modul_3.databinding.ActivityMainBinding
import com.example.modul_3.databinding.ActivityPage2Binding

class Page2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityPage2Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPage2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // ini adalah membuat variabel dan mengambil data string yang di kirimkan melalui intent dengan kunci "USER_INPUT"
        val receivedData = intent.getStringExtra("USER_INPUT")

        // Mengubah data menjadi sesuai dengan value receivedData
        binding.TV3.text = receivedData

        with(binding){
            buttonBack.setOnClickListener{
                val intentBack = Intent(this@Page2Activity,MainActivity::class.java)
                startActivity(intentBack)
            }
        }
    }
}