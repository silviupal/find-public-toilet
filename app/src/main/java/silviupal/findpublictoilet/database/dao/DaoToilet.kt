package silviupal.findpublictoilet.database.dao

import androidx.room.Dao
import androidx.room.Query
import silviupal.findpublictoilet.database.MyDatabase
import silviupal.findpublictoilet.database.entities.Toilet

/**
 * Created by Silviu Pal on 4/26/2019.
 */
@Dao
abstract class DaoToilet : BaseDao<Toilet> {
    @Query("SELECT * FROM ${MyDatabase.TABLE_PUBLIC_TOILET}")
    abstract fun getAllItems(): List<Toilet>

    @Query("SELECT * FROM ${MyDatabase.TABLE_PUBLIC_TOILET} WHERE id = :itemId")
    abstract fun getListItemById(itemId: Int): Toilet?
}