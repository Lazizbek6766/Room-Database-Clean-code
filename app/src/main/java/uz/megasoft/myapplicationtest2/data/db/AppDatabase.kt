package uz.megasoft.myapplicationtest2.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.megasoft.myapplicationtest2.domain.model.Item

@Database(entities = [Item::class], version = 2, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}