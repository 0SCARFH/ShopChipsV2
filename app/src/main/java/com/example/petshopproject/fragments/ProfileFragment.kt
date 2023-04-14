package com.example.petshopproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.petshopproject.R
import com.example.petshopproject.models.User

class ProfileFragment(private val user: User) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.profile_fragment, container, false)
        val username = view.findViewById<TextView>(R.id.username_profile)
        val email = view.findViewById<TextView>(R.id.email_profile)
        val phoneNumber = view.findViewById<TextView>(R.id.phone_number_profile)
        val location = view.findViewById<TextView>(R.id.location_profile)
        username.text = username.text.toString() + " " + user.username
        email.text = email.text.toString() + " " + user.email
        phoneNumber.text = phoneNumber.text.toString() + " " + user.phoneNumber
        location.text = location.text.toString() + " " + user.location
        val cancelButton = view.findViewById<Button>(R.id.cancel_profile)
        cancelButton.setOnClickListener {
            cancel()
        }
        return view
    }

    private fun cancel() {
        val fragmentManager = super.getActivity()?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.fragment, ShopsFragment(user))
        fragmentTransaction?.commit()
    }
}