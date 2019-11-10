package poapper.android.tutorial

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.week1_main.*

class Week1_MainActivity : AppCompatActivity() {

    private var ID: String = ""
    private var PW: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week1_main)

        /** 아래 3줄은 디자인을 위한거라 신경안쓰셔도 됩니다!
         *  액션바 숨기고, 상단 상태바 색상을 변경하는 부분입니다.
         */
        supportActionBar?.hide()
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.parseColor("#eeeeee")

        // Login 버튼 클릭시
        textView_login.setOnClickListener {
            // 입력한 ID, PW 값을 Layout에 있는 객체로부터 받아와요!
            ID = editText_id.text.toString()
            PW = editText_pw.text.toString()

            if (ID == "newbie@poapper.com" && PW == "qwerty123") {
                // 다음 화면으로 이동하기 위해 Intent를 생성하고 값을 넘겨줍니다.
                val intent = Intent(this, Week1_SubActivity::class.java)
                intent.putExtra("id", ID)

                startActivity(intent)
                finish()
            } else {
                // Toast 메세지를 띄워봐요!
                Toast.makeText(this, "Wrong ID or PW...", Toast.LENGTH_SHORT).show()
            }
        }

        // Join 버튼 클릭시
        textView_join.setOnClickListener {
            startActivity(Intent(this, Week1_JoinActivity::class.java))
        }
    }
}
