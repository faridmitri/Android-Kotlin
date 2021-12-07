package com.fm.apireadgithub

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.fm.apireadgithub.model.Items
import com.fm.apireadgithub.databinding.ItemBinding
import kotlinx.android.synthetic.main.item.view.*


class AdapterGit: RecyclerView.Adapter<AdapterGit.MyViewHolder>() {

    var items = ArrayList<Items>()

    fun setListData(data: ArrayList<Items>) {
        this.items = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterGit.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return MyViewHolder(inflater)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val avatarImg = view.avatarImg
        val reponame = view.repoName
        val avatarName = view.avatarName
        val numStars = view.numStars
        val description = view.description

        fun bind(data: Items) {
            reponame.text = data.name
            avatarName.text = data.owner.login
            numStars.text = data.stargazers_count.toString()
            if(!TextUtils.isEmpty(data.description)) {
                description.text = data.description
            } else {
                description.text = "No Desc available."
            }

            val url = data.owner.avatar_url

            avatarImg.load(url){
                placeholder(R.drawable.ic_img)
                crossfade(true)
                transformations(CircleCropTransformation())
            }

        }

    }


}




