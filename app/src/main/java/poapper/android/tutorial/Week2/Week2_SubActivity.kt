package poapper.android.tutorial.Week2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.week2_sub.*
import android.widget.Toast
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import poapper.android.tutorial.R

class Week2_SubActivity : AppCompatActivity(), View.OnClickListener {

    private var isFabOpen = false
    private lateinit var fab_open: Animation
    private lateinit var fab_close: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week2_sub)

        val myID = intent.getStringExtra("id") ?: "Error"
        textView_myID.text = myID

        // 애니메이션 설정
        fab_open = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        fab_close = AnimationUtils.loadAnimation(this, R.anim.fab_close)

        // 클릭 리스너
        fab.setOnClickListener(this)
        fab1.setOnClickListener(this)
        fab2.setOnClickListener(this)
        logout.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.fab -> {
                anim()
            }
            R.id.fab1 -> {
                anim()
                Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show()
            }
            R.id.fab2 -> {
                anim()
                Toast.makeText(this, "Create", Toast.LENGTH_SHORT).show()
            }
            R.id.logout -> {
                var editor = getSharedPreferences("pref", Context.MODE_PRIVATE).edit()
                editor.clear()
                editor.commit()

                val intent = Intent(this, Week2_LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun anim() {
        if (isFabOpen) {
            // 애니메이션 시작
            fab1.startAnimation(fab_close)
            fab2.startAnimation(fab_close)
            fab1.isClickable = false
            fab2.isClickable = false
            isFabOpen = false
        } else {
            fab1.startAnimation(fab_open)
            fab2.startAnimation(fab_open)
            fab1.isClickable = true
            fab2.isClickable = true
            isFabOpen = true
        }
    }
}
