package com.example.leduykhanh.smmapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.my_message.view.*
import kotlinx.android.synthetic.main.other_message.view.*

class MessageAdapter(val context: Context) : RecyclerView.Adapter<MessageViewHolder>(){

    private val messageList : ArrayList<Message> = ArrayList()

    inner class MyMessageViewHolder (view: View) : MessageViewHolder(view){
        private var messageText : TextView = view.txtMyMessage
        private var timeText : TextView = view.txtMyMessageTime

        override fun bind(message: Message) {
            messageText.text = message.message
            timeText.text = message.time
        }
    }

    inner class OtherMessageViewHolder (view: View) : MessageViewHolder(view){
        private var messageText : TextView = view.txtOtherMessage
        private var userText: TextView = view.txtOtherUser
        private var timeText: TextView = view.txtOtherMessageTime

        override fun bind(message: Message){
            messageText.text = message.message
            userText.text = message.user
            timeText.text = message.time
        }
    }

    fun addMessage(message: Message){
        messageList.add(message)
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return messageList[position].side
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override  fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return if(viewType == 1){
            MyMessageViewHolder(LayoutInflater.from(context).inflate(R.layout.my_message, parent, false))
        }
        else{
            OtherMessageViewHolder(LayoutInflater.from(context).inflate(R.layout.other_message, parent, false))
        }
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messageList.get(position)

        holder?.bind(message)
    }

}

open class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view){
    open fun bind(message: Message){
    }
}