package com.example.ladymobile

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ladymobile.databinding.ActivityMainHubBinding
import com.example.ladymobile.pertemuan_4.FourthActivity
import com.example.ladymobile.pertemuan_5.FifthActivity
import com.example.ladymobile.pertemuan_6.SplashScreenActivity
import com.example.ladymobile.pertemuan_7.Pertemuan7Activity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainHubBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainHubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Pertemuan 4
        binding.btnToFourth.setOnClickListener {
            val intent = Intent(this, FourthActivity::class.java)
            intent.putExtra("name", "Politeknik Caltex Rumbai")
            intent.putExtra("from", "Rumbai")
            intent.putExtra("age", 25)
            startActivity(intent)
        }

        // Pertemuan 5
        binding.btnToFifth.setOnClickListener {
            val intent = Intent(this, FifthActivity::class.java)
            startActivity(intent)
        }

        // Pertemuan 6
        binding.btnToSixth.setOnClickListener {
            val intent = Intent(this, SplashScreenActivity::class.java)
            startActivity(intent)
        }

        // Pertemuan 7
        binding.btnToSeventh.setOnClickListener {
            val intent = Intent(this, Pertemuan7Activity::class.java)
            startActivity(intent)
        }
    }
}
