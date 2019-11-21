package poapper.android.tutorial.Week2

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.content.Context
import android.content.SharedPreferences
import kotlinx.android.synthetic.main.week2_login.*
import poapper.android.tutorial.R
import poapper.android.tutorial.Week1.Week1_JoinActivity

class Week2_LoginActivity : AppCompatActivity() {

    private var ID: String = ""
    private var PW: String = ""

    private lateinit var pref: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week2_login)

        /** 아래 3줄은 디자인을 위한거라 신경안쓰셔도 됩니다!
         *  액션바 숨기고, 상단 상태바 색상을 변경하는 부분입니다.
         */
        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.parseColor("#eeeeee")

        pref = getSharedPreferences("pref", Context.MODE_PRIVATE)
        editor = pref.edit()

        uiSetting()
    }

    private fun uiSetting() {
        textView_login.setOnClickListener {
            ID = editText_id.text.toString()
            PW = editText_pw.text.toString()

            if (ID == "newbie@poapper.com" && PW == "qwerty123") {
                // 자동 로그인을 설정한 경우 SharedPreferences에 기록함
                if (checkBox.isChecked) {
                    editor.putBoolean("autoLogin", true)
                    editor.putString("ID", ID)
                }
                else editor.clear()
                editor.commit()

                val intent = Intent(this, Week2_SubActivity::class.java)
                intent.putExtra("id", ID)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Wrong ID or PW...", Toast.LENGTH_SHORT).show()
            }
        }

        textView_join.setOnClickListener {
            startActivity(Intent(this, Week1_JoinActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()

        // 자동 로그인을 설정한 경우 바로 다음 화면으로 넘어감
        if (pref.getBoolean("autoLogin", false)) {
            val intent = Intent(this, Week2_SubActivity::class.java)
            intent.putExtra("id", pref.getString("ID",""))
            startActivity(intent)
            finish()
        }
    }
}
