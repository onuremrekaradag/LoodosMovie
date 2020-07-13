package com.kefelon.loodosmovie.ui.moviedetail

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kefelon.loodosmovie.R
import com.kefelon.loodosmovie.base.BaseFragment
import com.kefelon.loodosmovie.databinding.FragmentMovieDetailBinding
import com.kefelon.loodosmovie.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_splash_screen.*
import kotlinx.android.synthetic.main.fragment_movie_detail.*

class MovieDetailFragment : BaseFragment() {

    private lateinit var binding: FragmentMovieDetailBinding
    private lateinit var viewModel: MovieDetailViewModel
    private lateinit var movieTitle: String
    private lateinit var movieYear: String
    private lateinit var moviePoster: String
    private lateinit var dataObserver: Observer<String>
    private lateinit var dataObserverYear: Observer<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getString("movieTitle")?.let {
            movieTitle = it
        }
        arguments?.getString("moviePoster")?.let {
            moviePoster = it
        }
        arguments?.getString("movieYear")?.let {
            movieYear = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val inflater = LayoutInflater.from(context)
        binding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            viewModelFactory
        ).get(MovieDetailViewModel::class.java)
        doDataBinding()
        sendDataToViewModel()

    }

    private fun sendDataToViewModel() {
        viewModel.movieTitle.value = movieTitle
        viewModel.movieYear.value = movieYear

        observeLiveData()
    }

    private fun observeLiveData() {
        dataObserver = Observer {
            text_view_movie_title.text = it
        }

        dataObserverYear = Observer {
            text_view_movie_rating.text = it
        }
        viewModel.movieTitle.observe(viewLifecycleOwner, dataObserver)
        viewModel.movieYear.observe(viewLifecycleOwner, dataObserverYear)

    }

    override fun getLayoutResId(): Int = R.layout.fragment_movie_detail

    override fun init() {
        context?.let {
            Glide.with(it)
                .setDefaultRequestOptions(RequestOptions())
                .load(moviePoster)
                .into(image_view_movie_poster)
        }
    }

    override fun doDataBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.executePendingBindings()
        init()
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.stop()
    }

}