package uz.megasoft.myapplicationtest2.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import uz.megasoft.myapplicationtest2.domain.model.Item
import uz.megasoft.myapplicationtest2.domain.use_case.GetItemsUseCase
import uz.megasoft.myapplicationtest2.domain.use_case.ItemUseCase
import uz.megasoft.myapplicationtest2.domain.use_case.SaveItemUseCase
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(
    private val itemUseCase: ItemUseCase
) : ViewModel() {

    fun saveItem(name: String, description: String) {
        val item = Item(name = name, description = description)
        viewModelScope.launch {
            itemUseCase.saveItemUseCase(item)
        }
    }

}