package com.cmartus.recycleviewwithintentsproject

import android.content.Intent
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import com.google.android.material.snackbar.Snackbar

import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            /*itemView.setOnClickListener{v: View ->
                var position: Int = getAdapterPosition()

                Snackbar.make(v, "Click detected on item $position",
                        Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }*/
            itemView.setOnClickListener{v: View ->
                val i = Intent(v.context,MainActivity2::class.java)
                var position: Int = adapterPosition
                i.putExtra("title", MainViewModel.randTitlesList[position])
                i.putExtra("detail",MainViewModel.randDetailsList[position])
                i.putExtra("image",MainViewModel.randImagesList[position])
                startActivity(v.context,i,null)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = MainViewModel.randTitlesList[i]
        viewHolder.itemDetail.text = MainViewModel.randDetailsList[i]
        viewHolder.itemImage.setImageResource(MainViewModel.randImagesList[i])
    }

    override fun getItemCount(): Int {
        return MainViewModel.randTitlesList.size
    }
}