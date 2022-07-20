package de.syntax_institut.funappsvorlage.data // ktlint-disable package-name

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.syntax_institut.funappsvorlage.data.model.Question

/**
 * Diese Klasse stellt die benötigten Informationen zur Verfügung
 */
class QuizRepository {

    private val _list = MutableLiveData<List<Question>>()
    val list: LiveData<List<Question>>
        get() = _list

    init {
        _list.value = loadQuestions()
    }

    /**
     * Diese Funktion liefert eine Liste an Question Objekten zurück, in denen die Frage, die
     * Antwortmöglichkeiten, der Index der richtigen Antwort und die Preisstufe gespeichert sind
     */
    private fun loadQuestions(): List<Question> {
        return listOf(
            Question(
                "Was ist \"Kotlin\"?",
                "Eine Automarke",
                "Ein Land",
                "Ein Gericht",
                "Eine Programmiersprache",
                4,
                50
            ),
            Question(
                "Welche View zeigt Texte an?",
                "TextView",
                "EditText",
                "ImageView",
                "View",
                1,
                100
            ),
            Question(
                "Wie heißt die Simulation eines Smartphones in Android Studio?",
                "Emulator",
                "Emulgator",
                "Elmolator",
                "Ellogator",
                1,
                200
            ),
            Question(
                "Wie konvertiert man zu einer Gleitkomazahl?",
                "toInt()",
                "toString()",
                "toChar()",
                "toDouble()",
                4,
                300
            ),
            Question(
                "Was gibt diese Funktion zurück?\nfun doStuff(nr: Int): String {...}",
                "Eine Kommazahl",
                "Einen Integer",
                "Einen String",
                "Einen fun",
                3,
                500
            ),
            Question(
                "Wofür steht \"Int\"",
                "Internal",
                "Internet",
                "Integer",
                "Instant",
                3,
                1000
            ),
            Question(
                "Wo kann man Bilder für die App importieren?",
                "Resource Manager",
                "Image Importer",
                "Foto Manager",
                "Picture CEO",
                1,
                2000
            ),
            Question(
                "Wie heißt die Verknüpfung von XML Elementen und Code?",
                "Info binding",
                "binding Info",
                "View binder",
                "Data binding",
                4,
                4000
            ),
            Question(
                "Wofür steht \"XML\"?",
                "Extra Module Language",
                "Extreme Management Language",
                "Extensible Markup Language",
                "Xylophone Melody Lover",
                3,
                8000
            ),
            Question(
                "Mit welchem Ausdruck spricht man die Farbe eines Themes an?",
                "?/attr",
                "@color",
                "@android",
                "?/theme",
                1,
                16000
            ),
            Question(
                "Welche Antwort ist Teil einer RecyclerView?",
                "Generator",
                "Pluck",
                "Adapter",
                "Port",
                3,
                32000
            ),
            Question(
                "Was ist kein Architekturmuster?",
                "MVVM",
                "MVP",
                "MVC",
                "MLP",
                4,
                64000
            ),
            Question(
                "Welches Objekt wird zum Starten einer Activity verwendet?",
                "Companion Object",
                "Intent",
                "Integer",
                "ActivityObject",
                2,
                125000
            ),
            Question(
                "Was ist keine Funktion der Adapterklasse einer RecyclerView?",
                "onCreateViewHolder()",
                "onBindViewHolder()",
                "onCreate()",
                "getItemCount()",
                3,
                500000
            ),
            Question(
                "Wofür steht MVVM",
                "Model View ViewModel",
                "ModelView View Model",
                "Model ViewModel View Model",
                "Markup View ViewModel",
                1,
                1000000
            )
        )
    }
}
