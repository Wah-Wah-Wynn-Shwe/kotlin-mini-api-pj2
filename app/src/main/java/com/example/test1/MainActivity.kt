package com.example.test1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.test1.Model.item
import com.example.test1.adapter.itemAdapter
import com.example.test1.webservice.ApiInterface
import com.example.test1.webservice.ServiceGenerator
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
    private var recyclerView: RecyclerView? = null
    private val items = ArrayList<item>()
    private var itemadapter: itemAdapter? = null
    private val linearLayoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recyclerview)

        recyclerView!!.layoutManager = LinearLayoutManager(this@MainActivity)
        itemadapter = itemAdapter(this@MainActivity, items)
        recyclerView!!.adapter = itemadapter


       /* run("https://api.github.com/users/Evin1-/repos")}
    fun run(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) = println(response.body()?.string())
        })*/
         getItems()
    }



             private fun getItems() {
        val apiInterface = ServiceGenerator.createService(ApiInterface::class.java)
        val call = apiInterface.getItems()
        call.enqueue(object : Callback<List<item>> {

            override fun onResponse(call: Call<List<item>>, response: Response<List<item>>) {
                if (response.isSuccessful) {
                    Log.d("GG_", "" + response.body()!!)
                    itemadapter!!.setitems(response.body()!!)
                } else {
                    Log.e(TAG, response.message())
                }
            }

            override fun onFailure(call: Call<List<item>>, t: Throwable) {
                Log.e(TAG, t.message)
            }
        })
        }
    }

