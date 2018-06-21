package com.example.leduykhanh.smmapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.loopj.android.http.JsonHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.Header
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.my_message.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import cz.msebera.android.httpclient.client.methods.RequestBuilder.post
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import android.widget.ScrollView





class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun startChat(v: View){
        val intent = Intent(this@MainActivity, ChatActivity::class.java)
        startActivity(intent)
    }
}
