package uz.megasoft.myapplicationtest2.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.megasoft.myapplicationtest2.domain.model.Item

@Dao
interface ItemDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertService(item: Item)

    @Query("SELECT * FROM item")
    fun getItems(): Flow<List<Item>>

    @Query("DELETE FROM item")
    suspend fun removeAllItem()
}