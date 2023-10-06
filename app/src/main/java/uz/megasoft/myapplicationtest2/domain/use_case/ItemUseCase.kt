package uz.megasoft.myapplicationtest2.domain.use_case

data class ItemUseCase (
    val saveItemUseCase: SaveItemUseCase,
    val getItemsUseCase: GetItemsUseCase,
    val removeUseCase: RemoveUseCase
)