package com.arraigntech.triviaapp.ui.flag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.arraigntech.triviaapp.databinding.FlagFragmentBinding
import com.arraigntech.triviaapp.ui.*

class FlagFragment : BaseFragment() {
    private lateinit var binding: FlagFragmentBinding
    private lateinit var factoryModel: FlagFactoryModel
    private lateinit var modelView: FlagModelView
    private var names: String = ""
    private var answer1: String = ""
    private var message: String = ""
    private var message1: String = ""
    private var message2: String = ""
    private var message3: String = ""

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FlagFragmentBinding.inflate(inflater)
        factoryModel = FlagFactoryModel(
            FlagFragmentArgs.fromBundle(
                arguments!!
            ).username,
            FlagFragmentArgs.fromBundle(
                arguments!!
            ).answerOne
        )
        modelView = ViewModelProvider(this, factoryModel).get(FlagModelView::class.java)
        binding.model = modelView
        modelView._userName.observe(viewLifecycleOwner, Observer { user ->
            names = user
        })
        modelView._answers.observe(viewLifecycleOwner, Observer { ans ->
            answer1 = ans
        })

        modelView._list.observe(viewLifecycleOwner, Observer { one ->
            message = one
        })
        modelView._list1.observe(viewLifecycleOwner, Observer { one ->
            message1 = one
        })
        modelView._list2.observe(viewLifecycleOwner, Observer { one ->
            message2 = one
        })
        modelView._list3.observe(viewLifecycleOwner, Observer { one ->
            message3 = one
        })
        binding.nextBT.setOnClickListener {
            val action =
                FlagFragmentDirections.actionFlagToSummary(
                    names,
                    answer1,
                    message,
                    message1,
                    message2,
                    message3
                )
            NavHostFragment.findNavController(this)
                .navigate(action)
        }
        return binding.root
    }
}