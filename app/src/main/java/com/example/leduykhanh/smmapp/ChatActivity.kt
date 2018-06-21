package com.example.leduykhanh.smmapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.loopj.android.http.JsonHttpResponseHandler
import com.loopj.android.http.RequestParams
import cz.msebera.android.httpclient.Header
import kotlinx.android.synthetic.main.activity_chat.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class ChatActivity : AppCompatActivity() {

    private var endpoint: String = "http://sandbox.api.simsimi.com/request.p?key=425e7213-ede7-4684-8bdf-92a79bf56805&lc=id&ft=1.0&text="
    private lateinit var messageAdapter: MessageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        messageList.layoutManager = LinearLayoutManager(this)
        messageAdapter = MessageAdapter(this)
        messageList.adapter = messageAdapter

    }

    fun submitChat(v: View){

//        messageAdapter.addMessage(Message(txtMessage.text.toString(),"ME", "12:10", 1))
//
//        messageAdapter.addMessage(Message("Hi","DT", "12:11", 0))
        var requestParam = RequestParams()
        var http = HttpUtils()
        http.get(txtMessage.text.toString(), RequestParams(), object : JsonHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, response: JSONArray?) {
                Log.d("asd", "---------------- this is response : $response")
                try {
                    val serverResp = JSONObject(response.toString())
                } catch (e: JSONException) {
                    e.printStackTrace()
                }

            }

            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, response: JSONObject?) {
                System.out.println(response)
                messageAdapter.addMessage(Message(txtMessage.text.toString(),"ME", "1 minute ago", 1))
                if (response != null) {
                    messageAdapter.addMessage(Message(response["response"].toString(),"DT", "1 minute ago", 0))
                }
                messageList.scrollToPosition(messageAdapter.itemCount - 1)
            }

        })
        messageList.adapter = messageAdapter
    }
}