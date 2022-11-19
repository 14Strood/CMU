package pt.ipp.estg.contactsroom.ui.models.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import pt.ipp.estg.contactsroom.ui.models.dao.ContactDao
import pt.ipp.estg.contactsroom.ui.models.enitities.Contact


@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class ContactDataBase : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {

        @Volatile
        private var INSTANCE: ContactDataBase? = null

        fun getDataBase(context: Context): ContactDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDataBase::class.java,
                    "contacts_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}