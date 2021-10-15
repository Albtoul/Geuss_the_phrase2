package com.example.geuss_the_phrase2


import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_message_adapter.view.*

class MessageAdapter(val context: Context, val messages: ArrayList<String>):
    RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {
    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.activity_message_adapter,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messages[position]

        holder.itemView.apply {
            tvMessage.text = message
            if(message.startsWith("Found")){
                tvMessage.setTextColor(Color.GREEN)
            }else if(message.startsWith("No")||message.startsWith("Wrong")){
                tvMessage.setTextColor(Color.RED)
            }else{
                tvMessage.setTextColor(Color.BLACK)
            }
        }
    }

    override fun getItemCount() = messages.size
}