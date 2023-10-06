package uz.megasoft.myapplicationtest2.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.megasoft.myapplicationtest2.domain.model.Item
import uz.megasoft.myapplicationtest2.domain.use_case.ItemUseCase
import javax.inject.Inject

@HiltViewModel
class ItemListVievModel @Inject constructor(
    private val itemUseCase: ItemUseCase
) : ViewModel() {

    // roomdan malumotlarni olish
    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> get() = _items

    init {
        viewModelScope.launch {
            getItems()
        }
    }

    private fun getItems() {
        viewModelScope.launch {
            itemUseCase.getItemsUseCase.invoke().collect { items ->
                _items.value = items
            }
        }
    }

    // roomdagi barcha malumotlarni o'chirish
    fun removeAllItems(){
        viewModelScope.launch {
            itemUseCase.allRemoveUseCase.invoke()
        }
    }

    // roomdagi bitta malumotlarni o'chirish
    fun removeItem(id: Int){
        viewModelScope.launch {
            itemUseCase.removeUseCase.invoke(id)
        }
    }
}