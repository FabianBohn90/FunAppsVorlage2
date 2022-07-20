package de.syntax_institut.funappsvorlage.ui.quiz // ktlint-disable package-name

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.syntax_institut.funappsvorlage.data.QuizRepository
import de.syntax_institut.funappsvorlage.data.model.Question

/**
 * Das ViewModel kümmert sich um die Logik des Spiels.
 * Es ruft dabei >keine< Variablen oder Funktionen aus dem QuizFragment auf
 */
class QuizViewModel : ViewModel() {

    // Erstelle eine QuizRepository Instanz
    private val repository = QuizRepository()

    // Lade die Liste mit den Question Informationen aus der QuizRepository Instanz
    private var questionList = repository.list

    // Der Index zeigt die Position der aktuellen Frage in der Liste
    private var index = 0

    // Diese Variable speichert die aktuelle Frage
    private var _currentQuestion = MutableLiveData<Question>(questionList.value?.get(index))
    val currentQuestion: LiveData<Question>
        get() = _currentQuestion

    // Diese Variable speichert die aktuelle Preisstufe
    private var _currentPrice = MutableLiveData<Int>(currentQuestion.value?.price)
    val currentPrice: LiveData<Int>
        get() = _currentPrice

    // Diese Variable speichert, ob das Spiel vorbei ist
    private var _gameOver = MutableLiveData<Boolean>(false)
    val gameOver: LiveData<Boolean>
        get() = _gameOver

    /**
     * Diese Funktion setzt alle Variablen auf ihren Ausgangswert zurück
     */
    private fun resetGame() {
        index = 0
        _currentPrice.value = 0
        _gameOver.value = false
    }

    /**
     * Diese Funktion überprüft, ob die Frage richtig oder falsch beantwortet wurde und setzt die
     * Variablen dementsprechend
     */
    fun checkAnswer(answerIndex: Int) {
        if (currentQuestion.value?.rightAnswer == answerIndex && index < questionList.value!!.size - 1) {
            index++
            _currentQuestion.value = questionList.value?.get(index)
            _currentPrice.value = currentQuestion.value?.price
        } else {
            _gameOver.value = true
            resetGame()
        }
    }
}
