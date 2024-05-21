package com.openclassrooms.notes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.openclassrooms.notes.databinding.ActivityMainBinding
import com.openclassrooms.notes.model.Note
import com.openclassrooms.notes.viewmodel.NoteViewModel
import com.openclassrooms.notes.widget.NoteItemDecoration
import com.openclassrooms.notes.widget.NotesAdapter

/**
 * The main activity for the app.
 */
class MainActivity : AppCompatActivity() {

    /**
     * The binding for the main layout.
     */
    private lateinit var binding: ActivityMainBinding

    private val oNotesAdapter = NotesAdapter(emptyList())

    //private val notesRepository = NotesRepository() // Old code
    // Now, I use a viewModel
    private lateinit var oNoteViewModel : NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Lien avec le ViewModel
        oNoteViewModel = ViewModelProvider(this)[NoteViewModel::class.java]

        initRecyclerView()
        initFABButton()

        //collectNotes()

        oNoteViewModel.oLiveDataNotes.observe(this, Observer<List<Note>> {
            oNotesAdapter.updateNotes(it)
        })


    }

//    /**
//     * OLD CODE : Collects notes from the repository and updates the adapter.
//     */
//    private fun collectNotes() {
//        lifecycleScope.launch {
////            notesRepository.notes.collect {
////                notesAdapter.updateNotes(it)
////            }
//            oNoteViewModel.notes.collect {
//                notesAdapter.updateNotes(it)
//            }
//
//
//        }
//    }

    /**
     * Initializes the FAB button.
     */
    private fun initFABButton() {
        binding.btnAdd.setOnClickListener {
            MaterialAlertDialogBuilder(this).apply {
                setTitle(R.string.coming_soon)
                setMessage(R.string.not_available_yet)
                setPositiveButton(android.R.string.ok, null)
            }.show()
        }
    }

    /**
     * Initializes the RecyclerView.
     */
    private fun initRecyclerView() {
        with(binding.recycler) {
            addItemDecoration(
                NoteItemDecoration(
                    resources.getDimensionPixelSize(R.dimen.default_margin),
                    resources.getInteger(R.integer.span_count)
                )
            )

            adapter = oNotesAdapter
        }

    }

}
