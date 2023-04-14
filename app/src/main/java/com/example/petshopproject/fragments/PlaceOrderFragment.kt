package com.example.petshopproject.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.petshopproject.R
import com.example.petshopproject.models.PlaceOrder
import com.example.petshopproject.models.Shop
import com.example.petshopproject.models.User
import com.google.firebase.firestore.FirebaseFirestore

class PlaceOrderFragment (private val shop: Shop, private val user: User) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.place_order_fragment, container, false)
        val db = FirebaseFirestore.getInstance()
        val yourCurrentLocation = view.findViewById<Button>(R.id.your_location)
        val anotherLocationInput = view.findViewById<TextView>(R.id.another_location_input)
        val anotherLocationButton = view.findViewById<Button>(R.id.another_location)
        val cancel = view.findViewById<Button>(R.id.cancel_place_order)
        yourCurrentLocation.setOnClickListener {
            if(user.orders.isNotEmpty()) {
                db.collection("orders").add(PlaceOrder(user.username, user.email, user.phoneNumber, user.location, user.orders))
                super.requireActivity().finish()
            }
        }
        anotherLocationButton.setOnClickListener {
            if(anotherLocationInput.text.isNotBlank()) {
                db.collection("orders").add(PlaceOrder(user.username, user.email, user.phoneNumber, anotherLocationInput.text.toString(), user.orders))
                super.requireActivity().finish()
            }
        }
        cancel.setOnClickListener {
            cancelPlaceOrder()
        }
        return view
    }

    private fun cancelPlaceOrder() {
        val fragmentManager = super.getActivity()?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.shopping_fragment, YourCartFragment(shop, user))
        fragmentTransaction?.commit()
    }
}