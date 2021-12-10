package com.bespalov.soccerquizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.bespalov.soccerquizapp.databinding.FragmentGoalBinding
import com.bespalov.soccerquizapp.databinding.FragmentMissBinding


class MissFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentMissBinding>(
            inflater, R.layout.fragment_miss, container, false
        )

        binding.OnMoreTimebutton.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_missFragment_to_quizFragment)
        }
        return binding.root
    }


}