package uz.megasoft.myapplicationtest2.domain.use_case

import uz.megasoft.myapplicationtest2.domain.model.Item
import uz.megasoft.myapplicationtest2.data.repository.ItemRepository

class SaveItemUseCase(
    private val repository: ItemRepository
) {
    suspend operator fun invoke(item: Item) {
        return repository.saveItem(item = item)
    }
}