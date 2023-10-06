package uz.megasoft.myapplicationtest2.domain.use_case

import kotlinx.coroutines.flow.Flow
import uz.megasoft.myapplicationtest2.db.ItemRepository
import uz.megasoft.myapplicationtest2.domain.model.Item

class RemoveUseCase(private val repository: ItemRepository) {
    suspend operator fun invoke() {
        return repository.removeAllItem()
    }
}