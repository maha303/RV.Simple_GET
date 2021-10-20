package com.example.rvsimple_get

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var rvMain :RecyclerView
    private lateinit var items:ArrayList<MyDataItem>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items= arrayListOf()

        rvMain=findViewById(R.id.rvMain)

        rvMain.adapter=RVAdapter(items)
        rvMain.layoutManager=LinearLayoutManager(this)


        val apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
        val call: Call<List<MyDataItem>> = apiInterface!!.doGetListResources()

        call.enqueue(object :Callback<List<MyDataItem>?>{
            override fun onResponse(call: Call<List<MyDataItem>?>,response: Response<List<MyDataItem>?>) {
             for (i in response.body()!!){
                 val name = i.name
                 items.add(MyDataItem(name))

             }
             rvMain.adapter!!.notifyDataSetChanged()
            }
            override fun onFailure(call:Call <List<MyDataItem>?>, t: Throwable) {
                call.cancel()
            }
        })
    }
}