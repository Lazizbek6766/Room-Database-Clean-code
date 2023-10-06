package uz.megasoft.myapplicationtest2.domain.use_case

import uz.megasoft.myapplicationtest2.domain.model.Item
import uz.megasoft.myapplicationtest2.db.ItemRepository

class SaveItemUseCase(
    private val itemRepository: ItemRepository
) {
    suspend operator fun invoke(item: Item) {
        return itemRepository.saveItem(item = item)
    }
}