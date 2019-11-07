package poapper.android.tutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.week1_sub.*

class Week1_SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week1_sub)

        // 앞에 Activity에서 넘어온 값을 Intent를 통해 받아옵니다!
        val myID = intent.getStringExtra("id") ?: "Error"
        textView_myID.text = myID
    }
}
