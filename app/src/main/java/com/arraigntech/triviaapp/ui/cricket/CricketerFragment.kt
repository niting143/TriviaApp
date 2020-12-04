package com.arraigntech.triviaapp.ui.cricket

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.arraigntech.triviaapp.databinding.CricketerLayoutFragmentBinding
import com.arraigntech.triviaapp.ui.*

class CricketerFragment : BaseFragment() {
    private lateinit var binding: CricketerLayoutFragmentBinding
    private lateinit var model: CricketFragmentModel
    private lateinit var modelFactory: CricketFragmentFactory
    private var answer: String = ""
    private var userName:String = ""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CricketerLayoutFragmentBinding.inflate(inflater)
        modelFactory =
            CricketFragmentFactory(
                CricketerFragmentArgs.fromBundle(
                    arguments!!
                ).userName
            )
        model = ViewModelProvider(this,modelFactory).get(CricketFragmentModel::class.java)
        binding.model = model

        model._id.observe(viewLifecycleOwner, Observer { id ->
            when (id) {
                binding.rOne.id -> answer = binding.rOne.hint.toString()
                binding.rTwo.id -> answer = binding.rTwo.hint.toString()
                binding.rThree.id -> answer = binding.rThree.hint.toString()
                binding.rFour.id -> answer = binding.rFour.hint.toString()
            }
        })
        model._userName.observe(viewLifecycleOwner, Observer { name->
            userName = name
        })
        binding.nextBT.setOnClickListener {
            Log.e("ids", answer)
            val action =
                CricketerFragmentDirections.actionCricketerToFlag(
                    userName,
                    answer
                )
            NavHostFragment.findNavController(this)
                .navigate(action)
        }
        return binding.root
    }
}