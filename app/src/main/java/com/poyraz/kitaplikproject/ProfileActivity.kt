package com.poyraz.kitaplikproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_home.*
import android.net.Uri
import android.view.MenuItem
import android.widget.PopupMenu
import androidx.annotation.MenuRes
import kotlinx.android.synthetic.main.activity_home.bottomNavigationView
import kotlinx.android.synthetic.main.activity_home.menuLayout
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        //Profile Photo
        val imageUri:Uri= Uri.parse("android.resource://" + getPackageName() + "/" + R.drawable.pp)
        Picasso.with(this).load(imageUri).into(profileImage)

        //Load fragmentHomePage
        val fragmentHomePage=FragmentHomePage()
        val fragmentManager=supportFragmentManager
        val transaction=fragmentManager.beginTransaction()
        transaction.replace(R.id.profileFrameLayout,fragmentHomePage)
        transaction.addToBackStack(null)
        transaction.commit()


        //BottomNavigationMenu Listener
        bottomNavigationView.setOnNavigationItemReselectedListener {

            when(it.itemId){
                R.id.menuMessage -> {
                    val messagesActivity=Intent(this,MessagesActivity::class.java)
                    startActivity(messagesActivity)
                    menuLayout.visibility=View.INVISIBLE
                }
                R.id.menuHome ->{
                    val homeActivity=Intent(this,HomeActivity::class.java)
                    startActivity(homeActivity)
                    menuLayout.visibility=View.VISIBLE
                }
                R.id.menuProfile ->{
                    val profileActivity=Intent(this,ProfileActivity::class.java)
                    startActivity(profileActivity)
                    menuLayout.visibility=View.VISIBLE
                }
                R.id.menuSettings ->{
                    val settingsActivity=Intent(this,SettingsActivity::class.java)
                    startActivity(settingsActivity)
                    menuLayout.visibility=View.INVISIBLE
                }
            }
        }
        bottomNavigationView.selectedItemId=R.id.menuProfile //default select


        categoryButtonProfile.setOnClickListener { v: View ->
            v.background=getDrawable(R.drawable.menu_buttons_click_color)
            categoryButton2Profile.background=getDrawable(R.drawable.menu_buttons_design)
            categoryButton3Profile.background=getDrawable(R.drawable.menu_buttons_design)
            showMenu(v, R.menu.category_menu)
        }
        categoryButton2Profile.setOnClickListener { v: View ->
            v.background=getDrawable(R.drawable.menu_buttons_click_color)
            categoryButtonProfile.background=getDrawable(R.drawable.menu_buttons_design)
            categoryButton3Profile.background=getDrawable(R.drawable.menu_buttons_design)
            showMenu(v, R.menu.category_menu)
        }
        categoryButton3Profile.setOnClickListener { v: View ->
            v.background=getDrawable(R.drawable.menu_buttons_click_color)
            categoryButtonProfile.background=getDrawable(R.drawable.menu_buttons_design)
            categoryButton2Profile.background=getDrawable(R.drawable.menu_buttons_design)
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
}