package com.sokhibdzhon.learningmotionlayout

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "TAG"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: Working!!!")
        button.setOnClickListener {
            with(findViewById<MotionLayout>(R.id.motionlayout)) {
                setTransition(R.id.start, R.id.end)
                transitionToEnd()
            }
            Toast.makeText(this, "Animation started", Toast.LENGTH_SHORT).show()
        }

    }
}
