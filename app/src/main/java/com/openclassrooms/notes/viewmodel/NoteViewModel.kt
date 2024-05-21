package com.openclassrooms.notes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.openclassrooms.notes.model.Note
import com.openclassrooms.notes.repository.NotesRepository

/**
 * Class who manage the iteraction between the Activity and the repository
 */
class NoteViewModel(applicationP : Application) : AndroidViewModel(applicationP) {

    // Data repository
    private var oRepository : NotesRepository

    // Livadata to sent Notes to the activity
    var oLiveDataNotes: LiveData<List<Note>>

    // Constructor
    init{
        oRepository = NotesRepository()
        oLiveDataNotes = oRepository.notes.asLiveData() // Convertir le Flow en LiveData pour l'observer dans la Vue
    }


}