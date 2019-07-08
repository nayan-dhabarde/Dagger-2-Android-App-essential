package com.example.daggerandroidtestapp

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.daggerandroidtestapp.di.Injectable
import com.example.daggerandroidtestapp.utils.putValues
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), Injectable {

    private val TEST_STRING: String = "HELLO"

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences.getString(TEST_STRING, String())?.let {
            if(it.isNotEmpty()) testTextView.text = it
        }

        btnSave.setOnClickListener {
            sharedPreferences.putValues {
                it.putString(TEST_STRING, editText.text.toString())
                Toast.makeText(this, "Saved to shared preferences!! DI Accomplished!!", Toast.LENGTH_LONG).show()
            }
        }
    }
}
