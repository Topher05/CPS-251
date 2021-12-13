package com.cmartus.contactsprojects

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*

class ContactRepository(application: Application) {

    val searchResults = MutableLiveData<List<Contact>>()
    private var contactDao: ContactDAO?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allContacts: LiveData<List<Contact>>?
    init {
        val db: ContactRoomDatabase? =
            ContactRoomDatabase.getDatabase(application)
        contactDao = db?.contactDao()
        allContacts = contactDao?.getAllContacts()
    }

    fun insertContact(newcontact: Contact){
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newcontact)
        }
    }

    private suspend fun asyncInsert(contact: Contact){
        contactDao?.insertContact(contact)
    }
    fun deleteContact(id: Int){
        coroutineScope.launch(Dispatchers.IO){
            asyncDelete(id)
        }
    }

    private suspend fun asyncDelete(id: Int){
        contactDao?.deleteContact(id)
    }

    fun findContact(name: String){

        coroutineScope.launch(Dispatchers.Main){
            searchResults.value = asyncFind(name).await()
        }
    }

    private suspend fun asyncFind(name: String): Deferred<List<Contact>?> =

        coroutineScope.async(Dispatchers.IO){
            return@async contactDao?.findContact(name)
        }

    fun getSortedListAsc(){
        coroutineScope.launch(Dispatchers.Main){
            searchResults.value = asyncGetSortedContactsAsc().await()
        }
    }

    private suspend fun asyncGetSortedContactsAsc(): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO){
            return@async contactDao?.getSortedListAsc()
        }


    fun getSortedListDesc(){
        coroutineScope.launch(Dispatchers.Main){
            searchResults.value = asyncGetSortedContactsDesc().await()
        }
    }

    private suspend fun asyncGetSortedContactsDesc(): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO){
            return@async contactDao?.getSortedListDesc()
        }

}