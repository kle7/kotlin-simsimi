package com.example.leduykhanh.smmapp

import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import com.loopj.android.http.RequestParams



class HttpUtils {

    private val BASE_URL = "http://sandbox.api.simsimi.com/request.p?key=425e7213-ede7-4684-8bdf-92a79bf56805&lc=id&ft=1.0&text="

    private val client = AsyncHttpClient()

    operator fun get(inputText: String, params: RequestParams, responseHandler: AsyncHttpResponseHandler) {
        client.get(getAbsoluteUrl(inputText), params, responseHandler)
    }

    fun getByUrl(url: String, params: RequestParams, responseHandler: AsyncHttpResponseHandler) {
        client.get(url, params, responseHandler)
    }

    private fun getAbsoluteUrl(text: String): String {
        return BASE_URL + text
    }
}