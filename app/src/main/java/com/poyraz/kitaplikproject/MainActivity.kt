package com.poyraz.kitaplikproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageViewLogo= findViewById<ImageView>(R.id.imageViewLogo)
        val _anim=AnimationUtils.loadAnimation(this,R.anim.logo_animation)
        imageViewLogo.startAnimation(_anim)



    }

    fun anaSayfayaGit(view: View){
        val intent=Intent(this,HomeActivity::class.java)
        startActivity(intent)
    }

    fun registerPage(view: View){
        val intent=Intent(this,RegisterActivity::class.java)
        startActivity(intent)
    }
}