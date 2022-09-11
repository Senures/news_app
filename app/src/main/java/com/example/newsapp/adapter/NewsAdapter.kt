package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.newsapp.HomeFragment
import com.example.newsapp.R
import com.example.newsapp.model.Article
import com.example.newsapp.databinding.HorizantalListItemBinding

class NewsAdapter:RecyclerView.Adapter<NewsAdapter.ArticleViewHolder> (){
    inner class ArticleViewHolder(val binding:HorizantalListItemBinding):RecyclerView.ViewHolder(binding.root)

    private val differCallback=object:DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
           return  oldItem.url==newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem==newItem
        }
    }

    private val differ=AsyncListDiffer(this,differCallback)
    var listNews:List<Article>
        //tanımladıgımız liste
        get() =differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
       return ArticleViewHolder(HorizantalListItemBinding.inflate(LayoutInflater.from(parent.context),
       parent,false)
       )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
       val currentItem=listNews[position]
        holder.binding.apply {
            imageView.load(currentItem.urlToImage){
                crossfade(enable = true)
                crossfade(durationMillis =1000)
            }
            textViewAuthor.text=currentItem.author
            textViewTitle.text=currentItem.title
        }

        holder.itemView.setOnClickListener{
              

        }
    }




    override fun getItemCount()=listNews.size
}