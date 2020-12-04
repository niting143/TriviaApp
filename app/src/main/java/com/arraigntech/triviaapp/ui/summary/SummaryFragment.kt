package com.arraigntech.triviaapp.ui.summary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.arraigntech.triviaapp.data.Questionaire
import com.arraigntech.triviaapp.data.QuestionaireDatabase
import com.arraigntech.triviaapp.databinding.SummaryFragmentBinding
import com.arraigntech.triviaapp.ui.*
import kotlinx.coroutines.launch

/**
 * Summary fragment
 *
 * @constructor Create empty Summary fragment
 */
class SummaryFragment : BaseFragment() {
    private lateinit var binding: SummaryFragmentBinding
    private lateinit var modelFactory: SummaryFactoryModel
    private lateinit var model: SummaryModel
    val sb = StringBuilder()
    var userName = ""
    var ans1 = ""
    var ans2 = "";

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SummaryFragmentBinding.inflate(inflater)
        modelFactory = SummaryFactoryModel(
            SummaryFragmentArgs.fromBundle(
                arguments!!
            ).userName,
            SummaryFragmentArgs.fromBundle(
                arguments!!
            ).answerOne,
            SummaryFragmentArgs.fromBundle(
                arguments!!
            ).checkOne,
            SummaryFragmentArgs.fromBundle(
                arguments!!
            ).checkTwo,
            SummaryFragmentArgs.fromBundle(
                arguments!!
            ).checkThree,
            SummaryFragmentArgs.fromBundle(
                arguments!!
            ).checkfour
        )
        model = ViewModelProvider(this, modelFactory).get(SummaryModel::class.java)
        model._userName.observe(viewLifecycleOwner, Observer { name ->
            binding.nameTV.setText(name)
            userName = name
        })
        model._answer.observe(viewLifecycleOwner, Observer { name ->
            binding.ansOneTV.setText(name)
            ans1 = name
        })
        model._ans2.observe(viewLifecycleOwner, Observer { name ->
            binding.ansTwoTV.text = name.removeSuffix(",")
            ans2 = name.removeSuffix(",")
        })

        binding.finishtBT.setOnClickListener {
            insertItem()
            NavHostFragment.findNavController(this)
                .navigate(SummaryFragmentDirections.actionSummaryToName())
        }

        binding.nextBT.setOnClickListener {
            insertItem()
            NavHostFragment.findNavController(this).navigate(SummaryFragmentDirections.actionSummaryToHistory())
        }

        return binding.root
    }

    private fun insertItem(){
        launch {
            val obj = Questionaire(
                userName,
                ans1,
                ans2
            )
            context?.let {
                QuestionaireDatabase(it).objDao().insert(obj)
            }
        }
    }
}