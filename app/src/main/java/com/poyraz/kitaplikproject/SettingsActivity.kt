package com.poyraz.kitaplikproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_messages.*
import kotlinx.android.synthetic.main.activity_settings.*

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)




        //Open fragmentSettingsPage
        val fragmentSettingsPage=FragmentSettingsPage()
        val fragmentManager=supportFragmentManager
        val transaction=fragmentManager.beginTransaction()
        transaction.replace(R.id.settingsFrameLayout,fragmentSettingsPage)
        transaction.addToBackStack(null)
        transaction.commit()

        //BottomNavigationMenu Listener
        settingsBottomNavigationView.selectedItemId=R.id.menuSettings
        settingsBottomNavigationView.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.menuMessage->{
                    val messagesActivity=Intent(this,MessagesActivity::class.java)
                    startActivity(messagesActivity)
                }
                R.id.menuSettings->{
                    val settingsActivity=Intent(this,SettingsActivity::class.java)
                    startActivity(settingsActivity)
                }
                R.id.menuProfile->{
                    val profileActivity=Intent(this,ProfileActivity::class.java)
                    startActivity(profileActivity)
                }
                R.id.menuHome->{
                    val homeActivity=Intent(this,HomeActivity::class.java)
                    startActivity(homeActivity)
                }
            }
        }
    }

}