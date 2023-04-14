package com.example.petshopproject.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.petshopproject.R
import com.example.petshopproject.models.User
import com.google.firebase.firestore.*

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.login_fragment, container, false)
        val username = view.findViewById<TextView>(R.id.username)
        val password = view.findViewById<TextView>(R.id.password)
        val login = view.findViewById<Button>(R.id.login_button)
        val register = view.findViewById<Button>(R.id.register_button)
        login.setOnClickListener {
            search(username.text.toString(), password.text.toString())
        }
        register.setOnClickListener {
            register()
        }
        return view
    }

    private fun logIn(user: User) {
        val fragmentManager = super.getActivity()?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.fragment, ShopsFragment(user))
        fragmentTransaction?.commit()
    }

    private fun register() {
        val fragmentManager = super.getActivity()?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.fragment, RegisterFragment())
        fragmentTransaction?.commit()
    }

    private fun search(username: String, password: String) {
        val db = FirebaseFirestore.getInstance()
        db.collection("users").addSnapshotListener(object:
            EventListener<QuerySnapshot> {
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                if(error != null) {
                    Log.e("Firestore error", error.message.toString())
                    return
                }
                for(dc: DocumentChange in value?.documentChanges!!) {
                    if (dc.type == DocumentChange.Type.ADDED) {
                        val user = dc.document.toObject(User::class.java)
                        if(user.username.equals(username) && user.password.equals(password)) {
                            logIn(user)
                        }
                        if(user.username.equals(username)) {
                            return
                        }
                    }
                }
            }
        })
    }
}