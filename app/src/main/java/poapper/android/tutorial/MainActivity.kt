package poapper.android.tutorial

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import poapper.android.tutorial.Week1.Week1_MainActivity
import poapper.android.tutorial.Week2.Week2_LoginActivity
import poapper.android.tutorial.Week3.Week3_MainActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.parseColor("#ffffff")

        button1.setOnClickListener { startActivity(Intent(this, Week1_MainActivity::class.java)) }
        button2.setOnClickListener { startActivity(Intent(this, Week2_LoginActivity::class.java)) }
        button3.setOnClickListener { startActivity(Intent(this, Week3_MainActivity::class.java)) }
    }
}
