package com.cmartus.navigationproject.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.cmartus.navigationproject.R
import com.cmartus.navigationproject.databinding.MainFragmentBinding
import android.util.Log

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private val TAG = "StateChange"
    private var _binding:MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        var imageId1 = resources.getIdentifier("android_image_1","drawable", context?.packageName)
        var imageId2 = resources.getIdentifier("android_image_2","drawable", context?.packageName)
        var imageId3 = resources.getIdentifier("android_image_3","drawable", context?.packageName)
        binding.button1.setOnClickListener{

            val action: MainFragmentDirections.ActionMainFragmentToSecondFragment = MainFragmentDirections.actionMainFragmentToSecondFragment(imageId1)

            action.buttonMessage = "Image 1"
            action.image = imageId1
            Navigation.findNavController(it).navigate(action)
        }

        binding.button2.setOnClickListener{

            val action: MainFragmentDirections.ActionMainFragmentToSecondFragment = MainFragmentDirections.actionMainFragmentToSecondFragment(imageId2)

            action.buttonMessage = "Image 2"
            action.image = imageId2
            Navigation.findNavController(it).navigate(action)
        }
        binding.button3.setOnClickListener{

            val action: MainFragmentDirections.ActionMainFragmentToSecondFragment = MainFragmentDirections.actionMainFragmentToSecondFragment(imageId3)

            action.buttonMessage = "Image 3"
            action.image = imageId3
            Navigation.findNavController(it).navigate(action)
        }
    }

}