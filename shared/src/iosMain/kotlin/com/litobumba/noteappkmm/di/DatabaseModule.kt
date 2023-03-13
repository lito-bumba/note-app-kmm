package com.litobumba.noteappkmm.di

import com.litobumba.noteappkmm.data.local.DatabaseDriverFactory
import com.litobumba.noteappkmm.data.note.SqlDelightNoteDataSource
import com.litobumba.noteappkmm.database.NoteDatabase
import com.litobumba.noteappkmm.domain.note.NoteDataSource

class DatabaseModule {
    private val factory by lazy { DatabaseDriverFactory() }
    val noteDataSource: NoteDataSource by lazy {
        SqlDelightNoteDataSource(NoteDatabase(factory.createDriver()))
    }
}