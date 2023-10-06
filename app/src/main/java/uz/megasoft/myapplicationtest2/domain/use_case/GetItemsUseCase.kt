package uz.megasoft.myapplicationtest2.domain.use_case

import kotlinx.coroutines.flow.Flow
import uz.megasoft.myapplicationtest2.domain.model.Item
import uz.megasoft.myapplicationtest2.db.ItemRepository

class GetItemsUseCase(private val itemRepository: ItemRepository) {
    operator fun invoke(): Flow<List<Item>> {
        return itemRepository.getItem()
    }
}