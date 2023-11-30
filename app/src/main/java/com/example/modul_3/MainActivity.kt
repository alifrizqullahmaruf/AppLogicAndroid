package com.example.modul_3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.modul_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding){
            // Ini adalah logic untuk pergi ke page2 dan menerima data text tersebut
            btnNext.setOnClickListener{
                val intent = Intent(this@MainActivity, Page2Activity::class.java)
                val userInput = ETnama.text.toString()

                intent.putExtra("USER_INPUT", userInput)
                startActivity(intent)
            }

            // ini adalah logic unutk mengirim text ke massage dan appnya dapat dipilih oleh user
            btnMassage.setOnClickListener{
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, "Hallo, this is the massage from my app")
                startActivity(Intent.createChooser(intent, "Select app"))
            }

            // ini adalah logic ketika user click button maka app akan membuka dial dan akan langsung terisi noHp ini
            btnDial.setOnClickListener{
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tell:082111492113")
                startActivity(intent)
            }

            // ini adalah logic ketika user cllick button open links maka app akan membuka langsung appnya atau linknya
            btnLink.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://www.youtube.com/watch?v=Pcc5SW6j-Gg")
                startActivity(Intent.createChooser(intent, "Select app"))
            }

        }
    }
}