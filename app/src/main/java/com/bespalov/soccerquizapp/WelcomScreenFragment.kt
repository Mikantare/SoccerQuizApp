
package com.bespalov.soccerquizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.bespalov.soccerquizapp.databinding.ActivityMainBinding
import com.bespalov.soccerquizapp.databinding.FragmentQuizBinding
import com.bespalov.soccerquizapp.databinding.FragmentWelcomScreenBinding


/**
 * A simple [Fragment] subclass.

 */
class WelcomScreenFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val binding = DataBindingUtil.inflate<FragmentWelcomScreenBinding>(
           inflater, R.layout.fragment_welcom_screen, container, false)

        (activity as AppCompatActivity).supportActionBar?.title = "Soccer Quiz"

        binding.buttonToPlay.setOnClickListener{view: View->
            Navigation.findNavController(view).navigate(R.id.action_welcomScreenFragment_to_quizFragment)
        }



        return binding.root
    }



}