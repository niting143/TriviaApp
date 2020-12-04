package com.arraigntech.triviaapp.ui.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arraigntech.triviaapp.adapters.ItemAdapter
import com.arraigntech.triviaapp.data.QuestionaireDatabase
import com.arraigntech.triviaapp.databinding.HistoryFragmentBinding
import com.arraigntech.triviaapp.ui.BaseFragment
import kotlinx.coroutines.launch

class HistoryFragment : BaseFragment(){
    private lateinit var binding:HistoryFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HistoryFragmentBinding.inflate(inflater)
            launch {
                context?.let {
                    val ques = QuestionaireDatabase(it).objDao().getLists()
                    binding.recyclerRV.adapter = ItemAdapter(ques);
                }
            }
        return binding.root
    }
}