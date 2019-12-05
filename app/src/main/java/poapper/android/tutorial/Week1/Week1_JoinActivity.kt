package poapper.android.tutorial.Week1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.week1_join.*
import kotlinx.android.synthetic.main.week1_join.toolBar
import kotlinx.android.synthetic.main.week1_main.editText_pw
import poapper.android.tutorial.R

class Week1_JoinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week1_join)

        /** 아래는 3줄은 나중에 배울 부분 입니다.
         * 신경 안쓰셔도 되요! */
        setSupportActionBar(toolBar)
        supportActionBar?.title = "Join"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        textView_Complete.setOnClickListener {
            if (editText_pw.text.toString() == editText_rpw.text.toString()) {
                Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
                // 가입 성공 후 엑티비티 종료
                finish()
            } else {
                Toast.makeText(this, "Wrong PW...", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /** 아래 함수는 나중에 배울 부분 입니다.
     * 신경 안쓰셔도 되요! */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
