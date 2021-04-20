package com.poyraz.kitaplikproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.annotation.MenuRes
import kotlinx.android.synthetic.main.activity_home.*
import java.lang.Exception

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val imageViewHomeLogo=findViewById<ImageView>(R.id.imageViewHomeLogo)
        val textViewSlogan=findViewById<TextView>(R.id.textViewSlogan)

        //Animation
        val logoAnimation=AnimationUtils.loadAnimation(this,R.anim.logo_animation)
        imageViewHomeLogo.startAnimation(logoAnimation)
        val sloganAnimation=AnimationUtils.loadAnimation(this,R.anim.slogan_animation)
        textViewSlogan.startAnimation(sloganAnimation)



        //BottomNavigationMenu Listener
        bottomNavigationView.setOnNavigationItemReselectedListener {

            try {
                when(it.itemId){
                    R.id.menuMessage -> {
                        val messagesActivity=Intent(this,MessagesActivity::class.java)
                        startActivity(messagesActivity)
                        //menuLayout.visibility=View.INVISIBLE
                    }
                    R.id.menuHome ->{
                        val homeActivity=Intent(this,HomeActivity::class.java)
                        startActivity(homeActivity)
                        //menuLayout.visibility=View.VISIBLE
                    }
                    R.id.menuProfile ->{
                        val profileActivity=Intent(this,ProfileActivity::class.java)
                        startActivity(profileActivity)
                        //menuLayout.visibility=View.VISIBLE
                    }
                    R.id.menuSettings ->{
                        val settingsActivity=Intent(this,SettingsActivity::class.java)
                        startActivity(settingsActivity)
                        //menuLayout.visibility=View.INVISIBLE
                    }
                }
            }catch (e:Exception){
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
            }

        }
        bottomNavigationView.selectedItemId=R.id.menuHome //default select


        // Open FragmentHomePage
        val fragmentHomePage=FragmentHomePage()
        val fragmentManager=supportFragmentManager
        val transaction=fragmentManager.beginTransaction()
        transaction.replace(R.id.homeFrameLayout,fragmentHomePage)
        transaction.addToBackStack(null)
        transaction.commit()


        //Menu
        categoryButton.setOnClickListener { v: View ->
            v.background=getDrawable(R.drawable.menu_buttons_click_color)
            categoryButton2.background=getDrawable(R.drawable.menu_buttons_design)
            categoryButton3.background=getDrawable(R.drawable.menu_buttons_design)
            showMenu(v, R.menu.category_menu)
        }
        categoryButton2.setOnClickListener { v: View ->
            v.background=getDrawable(R.drawable.menu_buttons_click_color)
            categoryButton.background=getDrawable(R.drawable.menu_buttons_design)
            categoryButton3.background=getDrawable(R.drawable.menu_buttons_design)
            showMenu(v, R.menu.category_menu)
        }
        categoryButton3.setOnClickListener { v: View ->
            v.background=getDrawable(R.drawable.menu_buttons_click_color)
            categoryButton.background=getDrawable(R.drawable.menu_buttons_design)
            categoryButton2.background=getDrawable(R.drawable.menu_buttons_design)
            showMenu(v, R.menu.category_menu)
        }

    }
    private fun showMenu(v: View, @MenuRes menuRes: Int) {
        val popup = PopupMenu(this, v)
        popup.menuInflater.inflate(menuRes, popup.menu)

        popup.setOnMenuItemClickListener { menuItem: MenuItem ->
            when(menuItem.itemId){
                R.id.takastakiKitaplar->{
                    true
                }
                R.id.askıdakiKitaplar->{
                    true
                }
                R.id.sosyalPaylasimlar->{
                    true
                }
            }
            true
        }
        popup.setOnDismissListener {
            // Respond to popup being dismissed.
        }
        // Show the popup menu.
        popup.show()
    }

    /*private fun makeCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.homeFrameLayout,fragment)
            commit()
        }
    }*/
}


