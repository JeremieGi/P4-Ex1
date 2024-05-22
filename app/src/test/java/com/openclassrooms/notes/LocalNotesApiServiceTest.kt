package com.openclassrooms.notes

import com.openclassrooms.notes.model.Note
import com.openclassrooms.notes.service.LocalNotesApiService
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class LocalNotesApiServiceTest {
    @Test
    fun test_AllNotes() {

        val localRep = LocalNotesApiService();
        assertEquals(localRep.getAllNotes().size,10)

    }

    @Test
    fun test_addNote() {

        val localRep = LocalNotesApiService();

        val nInitSize = localRep.getAllNotes().size

        val note = Note("Title","Test")
        localRep.addNote(note)

        assertEquals(localRep.getAllNotes().size,nInitSize+1)

    }

}