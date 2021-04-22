package com.poyraz.kitaplikproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val items=Array<String>(3){"Yaşadığı Şehir"}
        items[1]="Kayseri"
        items[2]="İstanbul"

        val spinnerAdapter=ArrayAdapter(this.applicationContext,android.R.layout.simple_spinner_item,items)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        citySpinner.adapter=spinnerAdapter
    }
}