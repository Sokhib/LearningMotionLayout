package com.sokhibdzhon.learningmotionlayout

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "TAG"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: Working!!!")
        var favored = false
        favIcon.setOnClickListener {
            (it as ImageView)
            if (!favored) {
                it.setColorFilter(ContextCompat.getColor(this, R.color.white))
            } else it.setColorFilter(ContextCompat.getColor(this, R.color.red))
            favored = !favored
        }

    }
}
