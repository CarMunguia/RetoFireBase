package com.example.retofirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.retofirebase.databinding.ActivityMainBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = Firebase.database
        val myRef  = database.reference

        myRef.child("peliculas")

        binding.btnSave.setOnClickListener{

            val title: String = binding.etTitle.text.toString()
            val year: Int = binding.etYear.text.toString().toInt()
            val imbdID: String = binding.etimbdID.text.toString()
            val type: String = binding.etType.text.toString()
            val poster: String = binding.etPoster.text.toString()
            val country: String = binding.etCountry.text.toString()
            val genre: String = binding.etGenre.text.toString()



            myRef.child("peliculas").child("1").setValue(pelicula(title, year, imbdID, type, poster, country, genre))

            binding.etTitle.setText("")
            binding.etYear.setText("")
            binding.etimbdID.setText("")
            binding.etType.setText("")
            binding.etPoster.setText("")
            binding.etCountry.setText("")
            binding.etGenre.setText("")


        }
    }
}