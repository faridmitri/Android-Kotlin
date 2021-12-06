package com.fm.apireadgithub

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.Transformation
import androidx.lifecycle.Transformations
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.fm.apireadgithub.databinding.ItemBinding

class AdapterGit(private var gitList:ArrayList<Items>): RecyclerView.Adapter<AdapterGit.ViewHolderGit>() {

    fun setData(list: ArrayList<Items>){
        this.gitList.addAll(list)
    }

// create an inner class with name ViewHolder
    // It takes a view argument, in which pass the generated class of single_item.xml
    // ie SingleItemBinding and in the RecyclerView.ViewHolder(binding.root) pass it like this

    class ViewHolderGit(val binding:ItemBinding):RecyclerView.ViewHolder(binding.root)

    // inside the onCreateViewHolder inflate the view of SingleItemBinding
    // and return new ViewHolder object containing this layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGit {
        val binding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolderGit(binding)
    }

    // bind the items with each item
    // of the list languageList
    // which than will be
    // shown in recycler view
    // to keep it simple we are
    // not setting any image data to view

    override fun onBindViewHolder(holder: ViewHolderGit, position: Int) {
        with(holder) {
            with(gitList[position]) {
                binding.avatarName.text = this.owner.login
                binding.description.text = this.description
                binding.repoName.text = this.name
                binding.numStars.text = this.stargazers_count.toString()
                val url:String = this.owner.avatar_url
                binding.avatarImg.load(url){
                    placeholder(R.drawable.ic_img)
                    crossfade(true)
                    transformations(CircleCropTransformation())

                }

            }
        }
    }

    override fun getItemCount(): Int = gitList.size


}