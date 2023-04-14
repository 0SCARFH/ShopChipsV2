package com.example.petshopproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.petshopproject.fragments.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeFragment()
    }

    private fun changeFragment() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.fragment, LoginFragment())
        fragmentTransaction.commit()
    }
}