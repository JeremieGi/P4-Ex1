package com.openclassrooms.notes.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.lifecycleScope
import com.openclassrooms.notes.model.Note
import com.openclassrooms.notes.repository.NotesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch


class NoteViewModel(applicationP : Application) : AndroidViewModel(applicationP) {


    private var oRepository : NotesRepository


    init{
        oRepository = NotesRepository()

        //oLiveDataAllNotes =
    }


    val notes: Flow<List<Note>> = oRepository.notes


}