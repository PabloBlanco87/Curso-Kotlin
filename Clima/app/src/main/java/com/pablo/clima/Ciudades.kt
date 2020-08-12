package com.pablo.clima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ciudades.*

class Ciudades : AppCompatActivity() {

    val TAG = "com.pablo.clima.ciudades.CIUDAD"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        val btnMadrid = findViewById<Button>(R.id.btMadrid)
        val btnBarcelona = findViewById<Button>(R.id.btBarcelona)
        val btnShangai = findViewById<Button>(R.id.btShangai)

        btMadrid.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG,"3117732")
            startActivity(intent)
        })

        btBarcelona.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG,"1726708")
            startActivity(intent)
        })

        btnShangai.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(TAG,"1796236")
            startActivity(intent)
        })
    }
}