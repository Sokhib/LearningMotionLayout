package com.sokhibdzhon.learningmotionlayout

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

private const val TAG = "TAG"

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var motionLayout: MotionLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        motionLayout = findViewById<MotionLayout>(R.id.motionlayout)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        imageview_true.setOnClickListener(null)
        imageview_false.setOnClickListener(null)
        imageview_pass.setOnClickListener(null)
        imageview_startGame.setOnClickListener { startGame ->
            viewModel.nextWord()
            startAnimation(imageview_pass)
            startGame.setOnClickListener(null)
            imageview_true.setOnClickListener {
                Log.d(TAG, "TRUE: Working!!!")
                startAnimation(it)
                viewModel.nextWord()
            }
            imageview_false.setOnClickListener {
                Log.d(TAG, "FALSE: Working!!!")
                startAnimation(it)
                viewModel.nextWord()
            }
            imageview_pass.setOnClickListener {
                Log.d(TAG, "PASS: Working!!!")
                startAnimation(it)
                viewModel.nextWord()
            }

        }

        viewModel.current.observe(this, Observer { currentWord ->
            sliderview.text = currentWord
        })

    }

    private fun startAnimation(view: View) {
        Log.d(TAG, "startAnimation: INSIDE")
        with(motionLayout) {
            when (view) {
                imageview_false -> {
                    setTransition(R.id.startLeft, R.id.endLeft)
                    transitionToEnd()
                }
                imageview_true -> {
                    setTransition(R.id.start, R.id.end)
                    transitionToEnd()
                }
                else -> {
                    setTransition(R.id.startPass, R.id.endPass)
                    transitionToEnd()
                }

            }


        }

    }
}
