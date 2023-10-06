package uz.megasoft.myapplicationtest2.db

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.megasoft.myapplicationtest2.Item

@Database(entities = [Item::class], version = 2, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}