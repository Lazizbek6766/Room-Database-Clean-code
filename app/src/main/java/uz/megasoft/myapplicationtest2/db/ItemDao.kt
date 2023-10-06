package uz.megasoft.myapplicationtest2.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import uz.megasoft.myapplicationtest2.Item

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertService(item: Item)
}