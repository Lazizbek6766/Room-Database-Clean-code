package uz.megasoft.myapplicationtest2.db

import uz.megasoft.myapplicationtest2.Item
import javax.inject.Inject

class ItemRepository @Inject constructor(
    private val itemDao: ItemDao
) {

    suspend fun saveItem(item: Item) = itemDao.insertService(item)

}
