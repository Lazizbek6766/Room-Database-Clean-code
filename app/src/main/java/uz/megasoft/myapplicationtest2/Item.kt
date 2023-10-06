package uz.megasoft.myapplicationtest2

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item")
data class Item (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val description: String
)