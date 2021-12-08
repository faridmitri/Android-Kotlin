package com.fm.apireadgithub

import android.text.TextUtils
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.fm.apireadgithub.model.Items
import com.fm.apireadgithub.databinding.ItemBinding
import kotlinx.android.synthetic.main.item.view.*
import java.util.logging.Level.INFO


class AdapterGit: RecyclerView.Adapter<AdapterGit.MyViewHolder>() {

    var item = ArrayList<Items>()

    fun setUpdatedData(item: ArrayList<Items>) {
        this.item = item
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount() : Int{
        Log.i("Size",item.size.toString())
        return  item.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(item.get(position))
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val avatarImg = view.findViewById<ImageView>(R.id.avatarImg)
        private val repoName = view.findViewById<TextView>(R.id.repoName)
        private val avatarName = view.findViewById<TextView>(R.id.avatarName)
        private val numStars = view.findViewById<TextView>(R.id.numStars)
        private val description = view.findViewById<TextView>(R.id.description)

        fun bind(data: Items) {
            repoName.text = data.name
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




