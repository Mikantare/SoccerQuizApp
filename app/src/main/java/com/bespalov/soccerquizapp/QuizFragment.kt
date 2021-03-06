package com.bespalov.soccerquizapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.bespalov.soccerquizapp.databinding.FragmentQuizBinding


/**
 * A simple [Fragment] subclass.
 */
class QuizFragment : Fragment() {

    private val quizItems: MutableList<QuizItem> = mutableListOf(
        QuizItem("How many players does each team have on the pitch when a soccer match starts?",
            listOf("11", "8", "12")),
        QuizItem("What should be the circumference of a Size 5 (adult) football?",
            listOf("27\" to 28\"", "24\" to 25\"", "23\" to 24\"")),
        QuizItem("What is given to a player for a very serious personal foul on an opponent?",
            listOf("Red Card", "Green Card", "Yellow Card")),
        QuizItem("To most places in the world, soccer is known as what?",
            listOf("Football", "Footgame", "Legball")),
        QuizItem("Offside. If a player is offside, what action does the referee take?",
            listOf("Awards an indirect free kick to the opposing team",
                "Awards a penalty to the opposing team",
                "Awards a yellow card to the player")),
        QuizItem("What should be the circumference of a Size 5 (adult) football?",
            listOf("17", "11", "23")),
        QuizItem("Excluding the goalkeeper, what part of the body cannot touch the ball?",
            listOf("Arm", "Head", "Shoulder")),
        QuizItem("What is it called when a player, without the ball on the offensive team is behind the last defender, or fullback?",
            listOf("Offside", "Outside", "Field-side")),
        QuizItem("The Ball. The circumference of the ball should not be greater than what?",
            listOf("70", "80", "90")),
        QuizItem("How many minutes are played in a regular game (without injury time or extra time)?",
            listOf("90", "95", "100")),
        QuizItem("What statement describes a proper throw-in?",
            listOf("Both hands must be on the ball behind the head, both feet must be on the ground",
                "Both hands must be on the ball behind the head",
                "Both feet must be on the ground")),
        QuizItem("How big is a regulation official soccer goal?",
            listOf("2.44m high, 7.32m wide", "2.55m high, 7.62m wide", "2.33m high, 8.15m wide"))
    )

    lateinit var currentQuizItem: QuizItem
    lateinit var currentAnswer: MutableList<String>
    var quizItemIndex = 0
    var numberOfQuestions = 3




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentQuizBinding>(
            inflater, R.layout.fragment_quiz, container, false)

        getRandomQuizItem()

        binding.buttonToAnswer.setOnClickListener { view: View->
            val selectedCheckBoxId = binding.quizeRadioGroup.checkedRadioButtonId
            if (selectedCheckBoxId != -1) {
            var answerIndex = 0
            when (selectedCheckBoxId) {
                R.id.radioButtonAnswer1 -> answerIndex = 0
                R.id.radioButtonAnswer2 -> answerIndex = 1
                R.id.radioButtonAnswer3 -> answerIndex = 2
            }
                if  (currentAnswer[answerIndex] == currentQuizItem.answerList[0]) {
                    quizItemIndex++
                    binding.quizeRadioGroup.clearCheck()
                    if (quizItemIndex < numberOfQuestions) {
                    getRandomQuizItem()
                        binding.invalidateAll()
                    } else {
                        // Go to Goal fragment
                        Navigation.findNavController(view).navigate(R.id.action_quizFragment_to_goalFragment)
                    }
                } else {
                    // Go to Miss fragment
                    Navigation.findNavController(view).navigate(R.id.action_quizFragment_to_missFragment)

                }

            }
        }
        binding.quizFragment = this
        return binding.root
    }

    private fun getRandomQuizItem () {
        quizItems.shuffle()
        currentQuizItem = quizItems[quizItemIndex]
        currentAnswer = currentQuizItem.answerList.toMutableList()
        currentAnswer.shuffle()
    }
}