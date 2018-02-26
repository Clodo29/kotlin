package com.example.andrericardodesouzaguedes.lottieanimation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.animation.ValueAnimator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        val animator = ValueAnimator.ofFloat(0f, 1f).setDuration(1000)
        animator.addUpdateListener { valueAnimator -> lottieAnimationView.progress = valueAnimator.animatedValue as Float }

        if (lottieAnimationView.progress == 0f) {
            animator.start()
        } else {
            lottieAnimationView.progress = 0f
        }
    }

}