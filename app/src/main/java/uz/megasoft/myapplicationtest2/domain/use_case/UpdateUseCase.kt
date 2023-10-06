package uz.megasoft.myapplicationtest2.domain.use_case

import uz.megasoft.myapplicationtest2.data.repository.ItemRepository
import uz.megasoft.myapplicationtest2.domain.model.Item

class UpdateUseCase (private val repository: ItemRepository) {
    suspend operator fun invoke(item: Item){
        return repository.updateItem(item)
    }
}