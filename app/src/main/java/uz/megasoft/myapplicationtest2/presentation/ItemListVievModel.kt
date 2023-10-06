package uz.megasoft.myapplicationtest2.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.megasoft.myapplicationtest2.domain.model.Item
import uz.megasoft.myapplicationtest2.domain.use_case.GetItemsUseCase
import javax.inject.Inject

@HiltViewModel
class ItemListVievModel @Inject constructor(
    private val getItemsUseCase: GetItemsUseCase
) : ViewModel() {

    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> get() = _items

    init {
        viewModelScope.launch {
            getItems()
        }
    }

    private fun getItems() {
        viewModelScope.launch {
            getItemsUseCase.invoke().collect { items ->
                _items.value = items
            }
        }
    }
}