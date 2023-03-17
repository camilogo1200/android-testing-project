package com.example.mytestapplication

import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<ImageView>(R.id.expand_me_btn)

        val td = TransitionDrawable(
            arrayOf<Drawable>(
                ResourcesCompat.getDrawable(resources, R.drawable.flashllght_off, null)!!,
                ResourcesCompat.getDrawable(resources, R.drawable.flash_light_on, null)!!
            )
        )
        var isFlashLightOn = false
        btn.setOnClickListener {
            btn.setImageDrawable(td)
            if (!isFlashLightOn) {
                td.startTransition(3000)
            } else {
                td.reverseTransition(3000)
                td.resetTransition()
            }
            isFlashLightOn = !isFlashLightOn
        }
    }

}