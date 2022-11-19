package pt.ipp.estg.contactsroom.ui.models.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import pt.ipp.estg.contactsroom.ui.models.enitities.Contact

@Dao
interface ContactDao {
    @Query("SELECT * FROM Contact")
    fun getAllContatcs(): LiveData<List<Contact>>

    @Query("select * from Contact where contactId = :contactId")
    fun getOnContact(contactId: Int): LiveData<Contact>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContact(vararg contacts: Contact)

    @Update
    fun updateContacts(vararg contacts: Contact)

    @Delete
    fun deleteContacts(vararg contacts: Contact)
}