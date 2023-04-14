package com.example.petshopproject.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.petshopproject.R
import com.example.petshopproject.models.Order
import com.example.petshopproject.models.Product
import com.example.petshopproject.models.Shop
import com.example.petshopproject.models.User

class ProductFragment (private val  product: Product, private val shop: Shop, private val user: User) : Fragment() {
    private var count: Int = 0
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.product_fragment, container, false)
        val productName = view.findViewById<TextView>(R.id.product_name)
        val productDescription = view.findViewById<TextView>(R.id.product_description)
        val productPrice = view.findViewById<TextView>(R.id.product_price)
        val counter = view.findViewById<TextView>(R.id.counter)
        val less = view.findViewById<Button>(R.id.less_button)
        val more = view.findViewById<Button>(R.id.more_button)
        val addToCart = view.findViewById<Button>(R.id.add_to_cart)
        val cancel = view.findViewById<Button>(R.id.cancel_order)
        productName.text = product.name
        productDescription.text = productDescription.text.toString() + " " + product.description
        productPrice.text = productPrice.text.toString() + " " + product.price.toString() + " RON"
        less.setOnClickListener {
            decreaseCount(counter)
        }
        more.setOnClickListener {
            increaseCount(counter)
        }
        addToCart.setOnClickListener {
            addOrderToCart()
        }
        cancel.setOnClickListener {
            cancelOrder()
        }
        return view
    }
    private fun decreaseCount(counter: TextView) {
        if(count != 0) {
            --count
            counter.text = count.toString()
        }
    }
    private fun increaseCount(counter: TextView) {
        ++count
        counter.text = count.toString()
    }
    private fun addOrderToCart() {
        if(count != 0) {
            user.addOrder(Order(count, product))
            cancelOrder()
        }
    }
    private fun cancelOrder() {
        val fragmentManager = super.getActivity()?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.shopping_fragment, ShopLayoutFragment(shop, user))
        fragmentTransaction?.commit()
    }
}