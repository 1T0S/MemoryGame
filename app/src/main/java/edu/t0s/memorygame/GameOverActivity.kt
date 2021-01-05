package edu.t0s.memorygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game_over.*

class GameOverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_over)

        val level: Int = intent.getIntExtra("level", -0);
        textViewGameOver.setText("Final level: $level")

        val intent: Intent = Intent(this, MainActivity::class.java)
        buttonRestart.setOnClickListener {
            startActivity(intent);
        }
    }
}