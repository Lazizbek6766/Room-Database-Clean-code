package uz.megasoft.myapplicationtest2.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Insert
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.megasoft.myapplicationtest2.Item
import uz.megasoft.myapplicationtest2.domain.use_case.SaveItemUseCase
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val saveItemUseCase: SaveItemUseCase
) : ViewModel() {

    fun saveItem(name: String, description: String) {
        val item = Item(name = name, description = description)
        viewModelScope.launch {
            saveItemUseCase(item)
        }
    }
}