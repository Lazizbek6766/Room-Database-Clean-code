package uz.megasoft.myapplicationtest2.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
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

    @Query("DELETE FROM item WHERE id =:id")
    suspend fun removeItem(id: Int)

    @Update
    suspend fun updateItem(item: Item)
}