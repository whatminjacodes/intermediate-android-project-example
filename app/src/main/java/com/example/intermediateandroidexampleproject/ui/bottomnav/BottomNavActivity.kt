package com.example.intermediateandroidexampleproject.ui.bottomnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.intermediateandroidexampleproject.R
import com.example.intermediateandroidexampleproject.databinding.ActivityBottomNavBinding

class BottomNavActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBottomNavBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBottomNavBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Navigation component
        val navigationView = binding.bottomNavigationView
        val navigationController = findNavController(R.id.bottomNavNavHostFragment)
        navigationView.setupWithNavController(navigationController)
    }
}