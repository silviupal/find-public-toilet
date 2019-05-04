package silviupal.findpublictoilet.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import silviupal.findpublictoilet.database.MyDatabase

/**
 * Created by Silviu Pal on 4/26/2019.
 */
@Entity(tableName = MyDatabase.TABLE_PUBLIC_TOILET)
data class Toilet(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var city: String,
    var latitude: String, // convert in Double when using it
    var longitude: String, // convert in Double when using it
    var votesCount: Int, // increase on user click. if more than 10, the toilet is officially correct
    var downvotesCount: Int // decrease on user click. show on screen on toilet details with like button or dislike button
)