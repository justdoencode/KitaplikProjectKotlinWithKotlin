package com.poyraz.kitaplikproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_messages.*

class MessagesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_messages)



        //Open fragmentMessagesPage
        val fragmentMessagesPage=FragmentMessagesPage()
        val fragmentManager=supportFragmentManager
        val transaction=fragmentManager.beginTransaction()
        transaction.replace(R.id.messagesFrameLayout,fragmentMessagesPage)
        transaction.addToBackStack(null)
        transaction.commit()


        //BottomNavigation Selected Listenner
        messagesBottomNavigationView.selectedItemId=R.id.menuMessage

        messagesBottomNavigationView.setOnNavigationItemReselectedListener {
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