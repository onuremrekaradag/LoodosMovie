package com.kefelon.loodosmovie.ui.moviesearch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kefelon.loodosmovie.R
import com.kefelon.loodosmovie.data.model.MovieModel
import com.kefelon.loodosmovie.databinding.ListMovieItemBinding
import com.kefelon.loodosmovie.ui.moviesearch.SearchNavigator

class MovieListAdapter(val movieList: ArrayList<MovieModel>, val listener: SearchNavigator) :
    RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    class ViewHolder(var binding: ListMovieItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model: MovieModel, listener: SearchNavigator, position: Int) {
            binding.model = model
            binding.position = position
            binding.listener = listener
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ListMovieItemBinding>(
            inflater,
            R.layout.list_movie_item,
            parent,
            false
        )
        return ViewHolder(
            binding
        )
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieList[position], listener, position)
    }

    fun notifyChanges(list: List<MovieModel>) {
        movieList.clear()
        movieList.addAll(list)
        notifyDataSetChanged()
    }
}