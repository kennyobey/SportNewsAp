package com.example.kennyobey.sportnewsapp.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import android.widget.Toast
import com.example.kennyobey.sportnewsapp.R
import com.example.kennyobey.sportnewsapp.datamodel.NewsFetch
import com.example.kennyobey.sportnewsapp.network.ApiClient
import com.example.kennyobey.sportnewsapp.network.ApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var popularNews : Call<NewsFetch>
    private lateinit var response : Response<NewsFetch>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val arti : List<String> = listOf("","","","")
        show_news.layoutManager = GridLayoutManager(this,2)
        // set an empty value to the adapter
       // show_news.adapter = NewsAdapter(this,popularNews)
        fetchNews(popularNews)



        ////////////////////////////

        runOnUiThread {
            //Do something on UiThread
            val users = response.body()!!
            val adapter = NewsAdapter(this@MainActivity, users)
            show_news.adapter = adapter
            adapter.notifyDataSetChanged()
        }


        //use the api cliient to get the api interface
        val apiInterface = ApiClient.getRetrofit().create(ApiInterface::class.java)
        //call the get popular latest news function
        popularNews = apiInterface.getNews("76e05fa7414946f0a4a5e283bd2229b6","us","popularity","sports")
        fetchNews(popularNews)
    }

    private fun fetchNews(popularNews: Call<NewsFetch>) {
        popularNews.clone().enqueue(object : Callback<NewsFetch> {
            override fun onFailure(call: Call<NewsFetch>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity, "Unable to connect "
                            + t.message, Toast.LENGTH_SHORT
                ).show()
              //  hideProgressBar()
                //show refresh button
              //  refresh_btn.visibility = View.VISIBLE
            }

            override fun onResponse(call: Call<NewsFetch>, response: Response<NewsFetch>) {
               show_news.adapter = NewsAdapter(this@MainActivity, response.body()!!)
                Toast.makeText(
                    this@MainActivity, "Hurray ", Toast.LENGTH_SHORT
                ).show()
            }

        })
    }
}
