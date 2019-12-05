package poapper.android.tutorial.Week3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.week3_main.*
import kotlinx.android.synthetic.main.week3_main.toolBar
import poapper.android.tutorial.R
import poapper.android.tutorial.Week3.Adapter.Week3_Adapter
import poapper.android.tutorial.Week3.Model.Week3_Post

class Week3_MainActivity : AppCompatActivity(), View.OnClickListener, Week3_Adapter.clickListener {

    override fun goNextPage(data: Week3_Post) {
        startActivity(
            Intent(this, Week3_SubActivity::class.java)
                .putExtra("title", data.title)
                .putExtra("name", data.name)
                .putExtra("time", data.time)
                .putExtra("content", data.content))
    }

    private var isFabOpen = false
    private lateinit var fab_open: Animation
    private lateinit var fab_close: Animation

    private val testData = ArrayList<Week3_Post>()
    private lateinit var mAdapter: Week3_Adapter<Week3_MainActivity>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week3_main)

        setSupportActionBar(toolBar)
        supportActionBar?.title = "게시판"

        // 애니메이션 설정
        fab_open = AnimationUtils.loadAnimation(this, R.anim.fab_open)
        fab_close = AnimationUtils.loadAnimation(this, R.anim.fab_close)

        // 클릭 리스너
        fab.setOnClickListener(this)
        fab1.setOnClickListener(this)
        fab2.setOnClickListener(this)


        // 테스트용 데이터
        testData.add(Week3_Post("작성자: 라이언", "13:00", "충격 고백!", "난 사실 사자임..."))
        testData.add(Week3_Post("작성자: 앙몬드", "10:00", "앙~앙앙", "앙몬드는 아몬드 먹고싶어욤 ><"))
        testData.add(Week3_Post("작성자: 죠르디", "17:00", "크아아앙", "난 공룡이야! \n" +
                "크앙\n" +
                "크앙\n" +
                "크앙\n" +
                "크앙\n" +
                "크앙\n" +
                "크앙\n" +
                "크앙\n" +
                "크앙\n" +
                "크앙\n" +
                "크앙\n" +
                "크앙\n" +
                "크앙\n" +"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                "크아아아아아!!!"))

        recyclerView.layoutManager = LinearLayoutManager(this)

        mAdapter = Week3_Adapter(this)
        recyclerView.adapter = mAdapter

        mAdapter.setData(testData)

        swipeRefresh.setOnRefreshListener {
            testData.add(Week3_Post("작성자: 무지", "18:00", "히히호호", "!!!"))
            mAdapter.setData(testData)
            swipeRefresh.isRefreshing = false
        }
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
