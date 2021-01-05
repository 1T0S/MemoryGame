package edu.t0s.memorygame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_game.*
import java.lang.Thread.sleep
import kotlin.random.Random

class GameActivity : AppCompatActivity() {
    private var vals: ArrayList<Int> = ArrayList<Int>()
    private var buttons: ArrayList<Button> = ArrayList<Button>()
    private var level: Int = 1;
    private var current: Int = 0;
    private lateinit var fajnyIntent: Intent;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        // Eh... tohle asi není úplně ideální postup
        buttons.add(findViewById(R.id.button1))
        buttons.add(findViewById(R.id.button2))
        buttons.add(findViewById(R.id.button3))
        buttons.add(findViewById(R.id.button4))
        buttons.add(findViewById(R.id.button5))
        buttons.add(findViewById(R.id.button6))
        buttons.add(findViewById(R.id.button7))
        buttons.add(findViewById(R.id.button8))
        buttons.add(findViewById(R.id.button9))

        // BETTER
        for(i in (1..9)){
            buttons.get(i - 1).setOnClickListener {
                current = i
                check()
            }
        }

        fajnyIntent = Intent(this, GameOverActivity::class.java)

        Thread(Runnable{
            while(true){
                for(b: Button in buttons){
                    b.isClickable = false;
                }
                blink()
                for(b: Button in buttons){
                    b.isClickable = true;
                }
                while(vals.isNotEmpty()){
                    println("DAMIANY");
                }
                level++;
                textViewLevels.setText("Level $level");
            }
        }).start();
    }

    private fun blink(){
        var blinks: Int = 0;
        textViewAction.setText("Wait");
        while(blinks != level){
            sleep(500);
            var current = (1..9).random();
            vals.add(current);
            buttons.get(current - 1).setBackgroundColor(getResources().getColor(R.color.red));
            sleep(1000);
            buttons.get(current - 1).setBackgroundColor(getResources().getColor(R.color.white));
            blinks++
            println("${vals.size}")
        }
        textViewAction.setText("Go");
    }

    private fun check(){
        if(current == vals[0]){
            vals.removeAt(0);
            println("Removed ${vals.size}");
        } else{
            fajnyIntent.putExtra("level", level);
            startActivity(fajnyIntent);
        }
    }


}