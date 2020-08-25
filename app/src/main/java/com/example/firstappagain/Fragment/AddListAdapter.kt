package com.example.firstappagain.Fragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstappagain.R

class AddListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<AddListAdapter.AddViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var adds = emptyList<Add>() // Cached copy of words

    class AddViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val addItemView: TextView = itemView.findViewById(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return AddViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AddViewHolder, position: Int) {
        val current = adds[position]
        holder.addItemView.text = current.add
    }

    internal fun setAdds(adds: List<Adds>) {
        this.adds = adds
        notifyDataSetChanged()
    }

    override fun getItemCount() = adds.size
}


