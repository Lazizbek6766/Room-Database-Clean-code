package uz.megasoft.myapplicationtest2.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.megasoft.myapplicationtest2.db.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun appDatabase(@ApplicationContext context: Context):AppDatabase  =
        Room.databaseBuilder(context, AppDatabase::class.java, "basket").fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun getItemDao(appDatabase: AppDatabase) = appDatabase.itemDao()
}