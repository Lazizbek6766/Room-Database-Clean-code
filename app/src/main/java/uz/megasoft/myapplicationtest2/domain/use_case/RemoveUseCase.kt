package uz.megasoft.myapplicationtest2.domain.use_case

import uz.megasoft.myapplicationtest2.data.repository.ItemRepository

class RemoveUseCase (private val repository: ItemRepository) {
    suspend operator fun invoke(id: Int) {
        return repository.removeItem(id)
    }
}