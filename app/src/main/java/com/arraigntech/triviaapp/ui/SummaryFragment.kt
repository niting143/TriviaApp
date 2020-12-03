package com.arraigntech.triviaapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.arraigntech.triviaapp.R
import com.arraigntech.triviaapp.databinding.SummaryFragmentBinding

class SummaryFragment : Fragment() {
    private lateinit var binding: SummaryFragmentBinding
    private lateinit var modelFactory: SummaryFactoryModel
    private lateinit var model: SummaryModel
    val sb = StringBuilder()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SummaryFragmentBinding.inflate(inflater)
        modelFactory = SummaryFactoryModel(
            SummaryFragmentArgs.fromBundle(arguments!!).userName,
            SummaryFragmentArgs.fromBundle(arguments!!).answerOne,
            SummaryFragmentArgs.fromBundle(arguments!!).checkOne,
            SummaryFragmentArgs.fromBundle(arguments!!).checkTwo,
            SummaryFragmentArgs.fromBundle(arguments!!).checkThree,
            SummaryFragmentArgs.fromBundle(arguments!!).checkfour
        )
        model = ViewModelProvider(this, modelFactory).get(SummaryModel::class.java)
        model._userName.observe(viewLifecycleOwner, Observer { name->
            binding.nameTV.setText(name)
        })
        model._answer.observe(viewLifecycleOwner, Observer { name->
            binding.ansOneTV.setText(name)
        })
        model._ans2.observe(viewLifecycleOwner, Observer { name->
                binding.ansTwoTV.text = name.removeSuffix(",")
        })

        binding.finishtBT.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(SummaryFragmentDirections.actionSummaryToName())
        }
        return binding.root
    }
}