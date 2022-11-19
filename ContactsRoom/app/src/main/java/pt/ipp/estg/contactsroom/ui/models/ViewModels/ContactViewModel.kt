package pt.ipp.estg.contactsroom.ui.models.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pt.ipp.estg.contactsroom.ui.models.Repository.ContactRepository
import pt.ipp.estg.contactsroom.ui.models.database.ContactDataBase
import pt.ipp.estg.contactsroom.ui.models.enitities.Contact

class ContactViewModel(application: Application) : AndroidViewModel(application) {

    val repository : ContactRepository
    val allContacts : LiveData<List<Contact>>

    init {
        val db = ContactDataBase.getDataBase(application)
        repository = ContactRepository(db.contactDao())
        allContacts = repository.getContacts()
    }

    fun insertContact(contact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(contact)
        }
    }

    fun deleteContact(contact: Contact) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(contact)
        }
    }

     fun findOneContact(contactId: Int): LiveData<Contact> {
        return repository.findOneContact(contactId)
    }
}