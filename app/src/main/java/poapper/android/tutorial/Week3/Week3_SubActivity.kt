package poapper.android.tutorial.Week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.week3_sub.*
import poapper.android.tutorial.R

class Week3_SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week3_sub)

        toolBar.title = "게시글"
        title_textView.text = intent.getStringExtra("title")
        time_textView.text = intent.getStringExtra("time")
        name_textView.text = intent.getStringExtra("name")
        content_textView.text = intent.getStringExtra("content")
    }
}
