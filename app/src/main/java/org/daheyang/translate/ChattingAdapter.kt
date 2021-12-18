package org.daheyang.translate

import android.os.Message
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ChattingAdapter (private val list: ArrayList<Message>) : RecyclerView.Adapter<ChattingAdapter.ChattingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChattingViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recyclerview, parent, false)

        return ChattingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChattingViewHolder, position: Int) {
        holder.message?.text = list[position].message
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ChattingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var message: TextView? = null
        init {
            message = view.findViewById(R.id.item_messagebubble)
        }
    }
    data class Message(val message: String)
}
