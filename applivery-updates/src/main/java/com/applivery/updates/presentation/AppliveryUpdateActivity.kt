package com.applivery.updates.presentation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.applivery.updates.R

class AppliveryUpdateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_applivery_update)


    }

    companion object {
        fun open(context: Activity) {
            val intent = Intent(context, AppliveryUpdateActivity::class.java)
            context.startActivity(intent)
            context.overridePendingTransition(
                R.anim.applivery_fade_in_anim,
                R.anim.applivery_fade_out_anim
            );
        }
    }
}