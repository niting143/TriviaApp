package com.arraigntech.triviaapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.arraigntech.triviaapp.R
import com.arraigntech.triviaapp.databinding.NameLayoutFragmentBinding


class NameFragment : Fragment() {
    private lateinit var binding: NameLayoutFragmentBinding
    private lateinit var model: NameFragmentModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NameLayoutFragmentBinding.inflate(inflater)
        model = ViewModelProvider(this).get(NameFragmentModel::class.java)
        binding.model = model
        model._isEnabled.observe(viewLifecycleOwner, Observer { isCheck ->
            if (isCheck) {
                binding.isEnabledButton = true
            } else
                binding.isEnabledButton = false
            //Log.e("enter", " Something")
        })
        binding.nextBT.setOnClickListener {
            val action = NameFragmentDirections.actionNameToCricketer(binding.nameET.text.toString())
            findNavController().navigate(action)
            binding.nameET.text.clear()
        }
        return binding.root
    }
}