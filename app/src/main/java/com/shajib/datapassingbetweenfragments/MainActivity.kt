package com.shajib.datapassingbetweenfragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.shajib.datapassingbetweenfragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //data passing between fragments

        //first fragment will be placed in the main activity container
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, FirstFragment(), "FirstFragment").commit()
    }
}