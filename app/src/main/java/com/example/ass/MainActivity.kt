package com.example.ass

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.t_list) as RecyclerView
        recyclerView!!.layoutManager = LinearLayoutManager(this);
        val url = "https://dev.priorsolution.co.th/"
        val retrofit = Retrofit.Builder().addConverterFactory(
            GsonConverterFactory.create(
                GsonBuilder().create()
            )
        )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(url).build()

        val postsApi = retrofit.create(INetworkAPI::class.java)
        val response = postsApi.getAllPosts()
        response.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(IoScheduler()).subscribe {
                if (it.isNotEmpty()) {
                    val job = it[0]
                    txtmessageCode.text = job.messageCode
                    txtmobileNo.text = job.mobileNo
                    txtrouteDate.text = job.routeDate
                    txttruckLicense.text = job.truckLicense
                    txtprovince.text = job.province
                    recyclerView!!.adapter = TestAdapter(job.sealImageList, this)
                }

            }
    }

    val B1 = 100
    fun newButtonClicked(view: View) {
        val intent = Intent(this, Act2::class.java)
        startActivityForResult(intent, B1)
    }
}