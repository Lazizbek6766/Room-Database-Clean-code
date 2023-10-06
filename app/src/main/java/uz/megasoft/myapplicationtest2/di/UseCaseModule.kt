package uz.megasoft.myapplicationtest2.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.megasoft.myapplicationtest2.data.repository.ItemRepository
import uz.megasoft.myapplicationtest2.domain.use_case.GetItemsUseCase
import uz.megasoft.myapplicationtest2.domain.use_case.ItemUseCase
import uz.megasoft.myapplicationtest2.domain.use_case.AllRemoveUseCase
import uz.megasoft.myapplicationtest2.domain.use_case.RemoveUseCase
import uz.megasoft.myapplicationtest2.domain.use_case.SaveItemUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideItemUseCase(repository: ItemRepository): ItemUseCase {
        return  ItemUseCase(
            getItemsUseCase = GetItemsUseCase(repository),
            saveItemUseCase = SaveItemUseCase(repository),
            allRemoveUseCase = AllRemoveUseCase(repository),
            removeUseCase = RemoveUseCase(repository)
        )
    }
}