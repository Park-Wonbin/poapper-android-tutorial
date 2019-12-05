package poapper.android.tutorial.Week5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.week3_main.*
import kotlinx.android.synthetic.main.week3_main.toolBar
import poapper.android.tutorial.R
import poapper.android.tutorial.Week3.Model.Week5_Post
import poapper.android.tutorial.Week5.Adapter.Week5_Adapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.Callback
import retrofit2.Response

class Week5_MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: Week5_Adapter

    private lateinit var mRetrofit: Retrofit
    private lateinit var mRetrofitAPI: RetrofitAPI
    private lateinit var mCallPostList: Call<List<Week5_Post>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week5_main)

        setSupportActionBar(toolBar)
        supportActionBar?.title = "Feed"

        recyclerView.layoutManager = LinearLayoutManager(this)

        mAdapter = Week5_Adapter()
        recyclerView.adapter = mAdapter

        retrofitInit()

        swipeRefresh.isRefreshing = true
        mCallPostList = mRetrofitAPI.getPost(20, 1)
        mCallPostList.enqueue(retrofitCallback)

        swipeRefresh.setOnRefreshListener {
            swipeRefresh.isRefreshing = true
            mCallPostList = mRetrofitAPI.getPost(20, 1)
            mCallPostList.enqueue(retrofitCallback)
        }
    }

    private fun retrofitInit() {
        mRetrofit = Retrofit.Builder()
            .baseUrl("https://rss-search-api.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        mRetrofitAPI = mRetrofit.create(RetrofitAPI::class.java)
    }

    internal interface RetrofitAPI {
        @GET("api/v1/channel/items/count/{count}")
        fun getPost(
            @Path("count") count: Int,
            @Query("id") id: Int
        ): Call<List<Week5_Post>>
    }

    private val retrofitCallback = object: Callback<List<Week5_Post>> {
        override fun onResponse(call:Call<List<Week5_Post>>, response: Response<List<Week5_Post>>) {
            if (response.isSuccessful) {
                response.body()?.get(0)?.items?.let { mAdapter.setData(it) }
                swipeRefresh.isRefreshing = false
            }
            else {
                Toast.makeText(applicationContext, response.message(), Toast.LENGTH_SHORT).show()
            }
        }
        override fun onFailure(call:Call<List<Week5_Post>>, t:Throwable) {
            t.printStackTrace()
            Toast.makeText(applicationContext, "Internet connection error", Toast.LENGTH_SHORT).show()
        }
    }
}
