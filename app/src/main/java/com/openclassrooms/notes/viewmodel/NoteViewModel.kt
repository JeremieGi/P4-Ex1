package com.openclassrooms.notes.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.openclassrooms.notes.model.Note
import com.openclassrooms.notes.repository.NotesRepository
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Class who manage the iteraction between the Activity and the repository
 */
@HiltViewModel
class NoteViewModel @Inject  constructor(

    // Data repository
    oRepository : NotesRepository // Param of the constructor

) : ViewModel() {

    // Livedata to sent Notes to the activity
    var oLiveDataNotes: LiveData<List<Note>>

    // Constructor
    init{

        oLiveDataNotes = oRepository.notes.asLiveData() // Convertir le Flow en LiveData pour l'observer dans la Vue
    }


}