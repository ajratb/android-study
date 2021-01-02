package com.example.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.lang.IllegalStateException

private const val TITLE_TYPE = 1
private const val DATA_TYPE = 2

//enum class ViewType (val type:Int){
//    TITLE_TYPE(1), DATA_TYPE(2)
//}

class MyRecyclerAdapter(private val data: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) {
            TITLE_TYPE
        } else {
            DATA_TYPE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from((parent.context))
        return when (viewType) {
            TITLE_TYPE -> MyTitleViewHolder(inflater.inflate(R.layout.title_view, parent, false))
            DATA_TYPE -> MyDataViewHolder(inflater.inflate(R.layout.data_view, parent, false))
            else -> throw IllegalStateException("Unknown type: $viewType")
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
       when (holder){
           is MyTitleViewHolder -> holder.bindTitle(data[position])
           is MyDataViewHolder -> holder.bindData(data[position])
       }
    }

    override fun getItemCount(): Int = data.size

}

class MyTitleViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    fun bindTitle(title: String) {
        (itemView as TextView).text = title
    }
}

class MyDataViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    fun bindData(data: String) {
        (itemView as TextView).text = data
    }
}