package pt.ipp.estg.contactsroom.ui.models.Repository

import androidx.lifecycle.LiveData
import pt.ipp.estg.contactsroom.ui.models.dao.ContactDao
import pt.ipp.estg.contactsroom.ui.models.enitities.Contact

class ContactRepository(val contactDao: ContactDao) {

    fun getContacts(): LiveData<List<Contact>> {
        return contactDao.getAllContatcs()
    }

    suspend fun insert(contact: Contact) {
        contactDao.insertContact(contact)
    }

    suspend fun delete(contact: Contact) {
        contactDao.deleteContacts(contact)
    }

    fun findOneContact(contactId: Int): LiveData<Contact> {
        return contactDao.getOnContact(contactId)
    }
}