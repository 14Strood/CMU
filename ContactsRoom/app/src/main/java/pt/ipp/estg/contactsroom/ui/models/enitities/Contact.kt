package pt.ipp.estg.contactsroom.ui.models.enitities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Contact(
    var name: String,
    var phoneNumber: String,
) {
    @PrimaryKey(autoGenerate = true)
    var contactId: Int = 0
}