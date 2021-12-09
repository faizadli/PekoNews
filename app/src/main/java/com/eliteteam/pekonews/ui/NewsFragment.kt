package com.eliteteam.pekonews.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.eliteteam.pekonews.NewsAdapter
import com.eliteteam.pekonews.NewsData
import com.eliteteam.pekonews.R
import com.eliteteam.pekonews.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {

    private var _binding: FragmentNewsBinding? = null

    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentNewsBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvNews.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 2)
            adapter = NewsAdapter(NewsData.listNews)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}