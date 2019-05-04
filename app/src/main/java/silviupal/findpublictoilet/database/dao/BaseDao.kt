package silviupal.findpublictoilet.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

/**
 * Created by Silviu Pal on 4/26/2019.
 */
interface BaseDao<in T> {
    @Insert
    fun insertOne(obj: T)

    @Update
    fun updateOne(obj: T)

    @Delete
    fun deleteOne(obj: T)
}