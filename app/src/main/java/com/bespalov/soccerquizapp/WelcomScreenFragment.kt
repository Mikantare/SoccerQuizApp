
package com.bespalov.soccerquizapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
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
       val binding = DataBindingUtil.inflate<FragmentQuizBinding>(
           inflater, R.layout.fragment_welcom_screen, container, false)

        return binding.root
    }


}