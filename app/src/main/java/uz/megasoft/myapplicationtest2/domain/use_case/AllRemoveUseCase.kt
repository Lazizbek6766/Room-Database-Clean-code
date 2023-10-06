package uz.megasoft.myapplicationtest2.domain.use_case

import uz.megasoft.myapplicationtest2.data.repository.ItemRepository

class AllRemoveUseCase(private val repository: ItemRepository) {
    suspend operator fun invoke() {
        return repository.removeAllItem()
    }
}