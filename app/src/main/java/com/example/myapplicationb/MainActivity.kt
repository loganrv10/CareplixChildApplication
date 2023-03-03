package com.example.myapplicationb

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplicationb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  lateinit var binding: ActivityMainBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
  }

  override fun onResume() {
    super.onResume()
    binding.button.setOnClickListener {
      if (!intent.getStringExtra("token").isNullOrEmpty()) {
        val intent = Intent("com.example.parentapplication")

        intent.putExtra("value", ReadingHelper.readFileResource("/Subham.json"))
        startActivity(intent)
      } else {
        Toast.makeText(this, "NO TOKEN FOUND", Toast.LENGTH_SHORT).show()
      }
    }
  }
}