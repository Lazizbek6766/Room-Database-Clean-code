package uz.megasoft.myapplicationtest2.db

import uz.megasoft.myapplicationtest2.domain.model.Item
import javax.inject.Inject

class ItemRepository @Inject constructor(
    private val itemDao: ItemDao
) {

    suspend fun saveItem(item: Item) = itemDao.insertService(item)

    fun getItem() = itemDao.getItems()

    suspend fun removeAllItem() = itemDao.removeAllItem()

}
