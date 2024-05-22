package com.openclassrooms.notes

import com.openclassrooms.notes.model.Note
import com.openclassrooms.notes.repository.NotesRepository
import com.openclassrooms.notes.service.LocalNotesApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class NotesRepositoryTest {

    @Test
    fun test_AllNotes() {

        val localRep = LocalNotesApiService();
        val notesRepository = NotesRepository(localRep);

        val notes: Flow<List<Note>> = notesRepository.notes

        // Utilisation de runBlocking pour collecter les éléments du flow
        // runBlocking uniquement dans des contextes où le blocage du thread principal est acceptable
        val notesList: List<Note> = runBlocking {
            notesRepository.notes.first()
        }

        Assert.assertEquals(notesList.size, 10)

    }

    @Test
    fun test_addNote() {

        val localRep = LocalNotesApiService();
        val notesRepository = NotesRepository(localRep);


        val nInitSize = localRep.getAllNotes().size

        val note = Note("Title","Test")
        notesRepository.addNote(note) // Flow est une API asynchrone

        // Utilisation de runBlocking pour collecter les éléments du flow
        // runBlocking uniquement dans des contextes où le blocage du thread principal est acceptable
        val notesList: List<Note> = runBlocking {
            notesRepository.notes.first()
        }

        Assert.assertEquals(notesList.size, nInitSize + 1)

    }

}