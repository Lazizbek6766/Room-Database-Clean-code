package uz.megasoft.myapplicationtest2.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.megasoft.myapplicationtest2.db.ItemRepository
import uz.megasoft.myapplicationtest2.domain.use_case.SaveItemUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideSaveItemUseCase(repository: ItemRepository): SaveItemUseCase {
        return SaveItemUseCase(repository)
    }
}