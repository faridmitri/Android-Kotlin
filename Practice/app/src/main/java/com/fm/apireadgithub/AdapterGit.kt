package com.fm.apireadgithub

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class AdapterGit(private var gitList:ArrayList<Items>): RecyclerView.Adapter<AdapterGit.ViewHolderGit>() {



    class ViewHolderGit(itemView:View):RecyclerView.ViewHolder(itemView) {

        val imgavatarImg:ImageView = itemView.findViewById(R.id.avatarImg)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGit {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return ViewHolderGit(view)
    }

    override fun onBindViewHolder(holder: ViewHolderGit, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int = gitList.size


}