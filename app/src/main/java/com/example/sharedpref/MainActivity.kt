package com.example.sharedpref

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpref.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sP = getSharedPreferences("info", MODE_PRIVATE)
        val editor = sP.edit()

        binding.apply {
        save.setOnClickListener {
            editor.apply(){
                putString("name",editName.text.toString())
                putString("mail",editEmail.text.toString())
                apply()
                Toast.makeText(this@MainActivity,"Information Saved",Toast.LENGTH_SHORT).show()
            }
        }
            load.setOnClickListener {
                name.text = sP.getString("name",null)
                email.text = sP.getString("mail",null)
                Toast.makeText(this@MainActivity,"Info Loaded",Toast.LENGTH_SHORT).show()
            }
        }
    }
}