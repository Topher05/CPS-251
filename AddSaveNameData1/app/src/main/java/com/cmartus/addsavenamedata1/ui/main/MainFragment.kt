package com.cmartus.addsavenamedata1.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.cmartus.addsavenamedata1.databinding.MainFragmentBinding

class MainFragment : Fragment() {


    private lateinit var viewModel: MainViewModel
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        binding.displayName.text = viewModel.getNameList().toString()

        binding.addName.setOnClickListener{
            if (binding.editTextTextPersonName.text.isNotEmpty()){
                viewModel.addNames(binding.editTextTextPersonName.text.toString())
                binding.displayName.text = viewModel.getNameList().toString()
            } else{
                binding.displayName.text = "No Names To Display"
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}