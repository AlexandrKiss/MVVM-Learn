package ua.kiss.mvvm_learn

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ua.kiss.mvvm_learn.view.hw02.TimeActivity
import ua.kiss.mvvm_learn.view.less02.TestActivity

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startLesson02Activity(view: View) {
        startActivity(Intent(this@MainActivity, TestActivity::class.java))
    }

    fun startHomeWork02Activity(view: View) {
        startActivity(Intent(this@MainActivity, TimeActivity::class.java))
    }
}