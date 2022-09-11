package com.example.newsapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.newsapp.databinding.FragmentFirstPageBinding

class FirstPageFragment : Fragment() {

    private lateinit var binding: FragmentFirstPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentFirstPageBinding.inflate(inflater, container, false)
        binding.button.setOnClickListener{
            //butona tıkaldıgında diğer fragmenta geçme işlemi
            Navigation.findNavController(it).navigate(R.id.action_firstPageFragment_to_homeFragment)
            println("buttona tıklandı")
        }
        return  binding.root


    }


}