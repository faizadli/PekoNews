package com.eliteteam.pekonews

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.eliteteam.pekonews.databinding.LayoutNewsBinding

class NewsAdapter(private val listNews: ArrayList<News>) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: LayoutNewsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutNewsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {

            with(listNews[position]) {
                tvItemName.text = name
                tvItemDate.text = date
                Glide.with(imgItemPhoto.context).load(photo).into(imgItemPhoto)
            }
        }

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.NEWS_DATA, listNews[position])
            it.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int = listNews.size
}