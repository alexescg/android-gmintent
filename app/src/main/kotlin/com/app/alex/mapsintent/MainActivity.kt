package com.app.alex.mapsintent

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_findCategory.setOnClickListener { getGoogleMapsIntent() }
    }

    fun getGoogleMapsIntent(): Unit {
        val category: String? = edit_lookingFor.text.toString()
        if (!category.isNullOrEmpty()) {
            val gmmIntentUri: Uri = Uri.parse("geo:0,0?q=" + category)
            val mapIntent: Intent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)

        }
    }
}
