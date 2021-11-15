package com.cmartus.recycleviewproject

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar

import androidx.recyclerview.widget.RecyclerView

import com.cmartus.recycleviewproject.R
import java.util.*
import java.util.Collections.shuffle
import kotlin.random.Random

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    //private var mainViewModel: MainViewModel = MainViewModel()
    private var mainActivity: MainActivity = MainActivity()

    private var randTitles = mainActivity.mainViewModel.getTitles()

    private var randDetails = mainActivity.mainViewModel.getDetails()

    private var randImages = mainActivity.mainViewModel.getImages()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init {
            itemImage = itemView.findViewById(R.id.itemImage)
            itemTitle = itemView.findViewById(R.id.itemTitle)
            itemDetail = itemView.findViewById(R.id.itemDetail)

            itemView.setOnClickListener{v: View ->
                var position: Int = getAdapterPosition()

                Snackbar.make(v, "Click detected on item $position",
                        Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.card_layout,viewGroup,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = randTitles[i]
        viewHolder.itemDetail.text = randDetails[i]
        viewHolder.itemImage.setImageResource(randImages[i])
    }

    override fun getItemCount(): Int {
        return randTitles.size
    }
}