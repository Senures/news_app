package com.example.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.databinding.FragmentHomeBinding
import com.example.newsapp.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeViewModel by viewModels()
    lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //BINDING İŞLEMİ ONCREATE VİEW İÇİNDE YAPILIR
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()

        binding.newsAdapter.apply {
      //recycler ile adapterı bağlama kısmı
            layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
            setHasFixedSize(true)
        }
        //viewmodeldeki anlık değişen veriyi izle
        //adapterın listesine at sonra adapter ile recyler bağla
        viewModel.responseNews.observe(requireActivity(), { response ->
            newsAdapter.listNews = response
            //adapterin listesine ata
            //sonra recyclerın adapterine ata
            binding.newsAdapter.adapter=newsAdapter
        })
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }
}



