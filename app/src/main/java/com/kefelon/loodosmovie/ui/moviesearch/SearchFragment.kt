package com.kefelon.loodosmovie.ui.moviesearch

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.kefelon.loodosmovie.R
import com.kefelon.loodosmovie.base.BaseActivity
import com.kefelon.loodosmovie.base.BaseFragment
import com.kefelon.loodosmovie.data.model.MovieModel
import com.kefelon.loodosmovie.databinding.FragmentSearchBinding
import com.kefelon.loodosmovie.extensions.setEmptyViewVisible
import com.kefelon.loodosmovie.ui.LoadingView
import com.kefelon.loodosmovie.ui.moviesearch.adapter.MovieListAdapter
import kotlinx.android.synthetic.main.fragment_search.*


class SearchFragment : BaseFragment(), SearchNavigator {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var viewModel: SearchViewModel
    private lateinit var showLoadingObserver: Observer<Boolean>

    private val adapter: MovieListAdapter =
        MovieListAdapter(
            arrayListOf(),
            this
        )


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
        ).get(SearchViewModel::class.java)
        doDataBinding()
    }

    override fun getLayoutResId(): Int = R.layout.fragment_search

    override fun init() {
        binding.adapter = adapter
        binding.navigator = this
    }

    override fun doDataBinding() {
        binding.lifecycleOwner = viewLifecycleOwner
        binding.executePendingBindings()
        init()
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.movies.observe(viewLifecycleOwner, Observer { list ->
            list?.let {
                binding.adapter!!.notifyChanges(it)
            }
            text_view_empty.setEmptyViewVisible(list.isEmpty())
            recycler_view_movie_list.setEmptyViewVisible(list.isNotEmpty())
        })
        var dialog = LoadingView(requireActivity())
        viewModel.showLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            if (isLoading) {
                dialog.show()
            } else
                dialog.hide()
        })
    }


    override fun onSearch() {
        if (edit_text_search.text.toString().isNotEmpty()) {
            viewModel.getMovieList(
                searchString = edit_text_search.text.toString()
            )
            edit_text_search.clearFocus()
        } else {
            Toast.makeText(context, "Lütfen geçerli bir arama yapınız.", Toast.LENGTH_SHORT).show()
        }
    }


    override fun goDetail(movie: MovieModel, position: Int) {

        val action =
            SearchFragmentDirections.actionSearchFragmentToMovieDetailFragment(
                movie.title,
                movie.poster,
                movie.year
            )
        Navigation.findNavController(this.requireView()).navigate(action)
    }

}
