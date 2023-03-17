package com.example.mytestapplication

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<ImageView>(R.id.expand_me_btn)
        val tooltipFlashLight = findViewById<ImageView>(R.id.tooltip_flashlight)

        val td = TransitionDrawable(
            arrayOf<Drawable>(
                ResourcesCompat.getDrawable(resources, R.drawable.flashllght_off, null)!!,
                ResourcesCompat.getDrawable(resources, R.drawable.flash_light_on, null)!!
            )
        )
        var isFlashLightOn = false
        btn.setOnClickListener {
            tooltipFlashLight.isGone = true
            handleButtonClicked(btn, td, isFlashLightOn)
            isFlashLightOn = !isFlashLightOn
        }


        val animatorFadeOut = ObjectAnimator.ofFloat(tooltipFlashLight, "alpha", 1F, 0F).apply {
            duration = 750
            start()
        }

        val animatorFadeIn = ObjectAnimator.ofFloat(tooltipFlashLight, "alpha", 0F, 1F).apply {
            duration = 750
            start()
        }

        animatorFadeIn.duration = 950;
        animatorFadeIn.repeatCount = 2;
        animatorFadeIn.repeatMode = ValueAnimator.REVERSE;
        animatorFadeIn.start()
//        val blinkAnimation = AnimatorSet().apply {
//            play(animatorFadeIn).after(animatorFadeOut)
//            play(animatorFadeIn).before(animatorFadeOut)
//        }
//
//        blinkAnimation.start()
//        //        AnimatorSet().apply {
//            play(bou)
//        }

    }

    private fun handleButtonClicked(
        btn: ImageView, td: TransitionDrawable, isFlashLightOn: Boolean
    ) {
        var isFlashLightOn1 = isFlashLightOn
        btn.setImageDrawable(td)
        if (!isFlashLightOn1) {
            td.startTransition(3000)
            btn.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources, R.drawable.flash_light_on, null
                )
            )
        } else {
            td.reverseTransition(3000)
            td.resetTransition()
            btn.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources, R.drawable.flashllght_off, null
                )
            )
        }

    }

}