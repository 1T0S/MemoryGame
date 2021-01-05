package edu.t0s.memorygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // Kotlin -> KotlinAndroidExtensionsPlugin, možno přeskočit definici objektů a findViewById()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPlay.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent);
        }
    }
}