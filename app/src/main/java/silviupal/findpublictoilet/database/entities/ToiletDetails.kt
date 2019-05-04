package silviupal.findpublictoilet.database.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import silviupal.findpublictoilet.database.MyDatabase

/**
 * Created by Silviu Pal on 4/26/2019.
 */

/*
    This will stand as an example of foreign key in Room
 */

@Entity(tableName = MyDatabase.TABLE_PUBLIC_TOILET_DETAILS,
    foreignKeys = [ForeignKey(entity = Toilet::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("toiletId"))])
data class ToiletDetails(
    @PrimaryKey(autoGenerate = true)
    val detailsId: Int,
    val toiletId: Int
)

