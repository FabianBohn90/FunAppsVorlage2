package de.syntax_institut.funappsvorlage.ui.quiz // ktlint-disable package-name

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import de.syntax_institut.funappsvorlage.databinding.FragmentQuizBinding

/**
 * Diese Klasse kümmert sich um die richtige Darstellung von UI Elementen.
 * Es ändert dabei >keine< Variablen im ViewModel
 */
class QuizFragment : Fragment() {

    // Hier wird das ViewModel, in dem die Logik stattfindet, geholt
    private val viewModel: QuizViewModel by viewModels()

    // Das binding für das QuizFragment wird deklariert
    private lateinit var binding: FragmentQuizBinding

    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewmodel = viewModel

        binding.lifecycleOwner = viewLifecycleOwner

        // Setze onClickListeners
        binding.tvAnswerA.setOnClickListener {
            viewModel.checkAnswer(1)
        }
        binding.tvAnswerB.setOnClickListener {
            viewModel.checkAnswer(2)
        }
        binding.tvAnswerC.setOnClickListener {
            viewModel.checkAnswer(3)
        }
        binding.tvAnswerD.setOnClickListener {
            viewModel.checkAnswer(4)
        }

        // Beobachte die gameOver Variable des viewModel, falls das Spiel vorbei ist
        viewModel.gameOver.observe(
            viewLifecycleOwner
        ) {
            if (it) {
                findNavController().navigate(
                    QuizFragmentDirections.actionQuizFragmentToResultFragment()
                )
            }
        }
    }
}
