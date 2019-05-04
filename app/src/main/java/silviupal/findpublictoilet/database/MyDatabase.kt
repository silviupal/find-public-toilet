package silviupal.findpublictoilet.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import silviupal.findpublictoilet.MyApp
import silviupal.findpublictoilet.database.entities.Toilet
import silviupal.findpublictoilet.database.entities.ToiletDetails

/**
 * Created by Silviu Pal on 4/26/2019.
 */
@Database(entities = [Toilet::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME: String = "toilets_db"
        const val TABLE_PUBLIC_TOILET = "toilet"
        const val TABLE_PUBLIC_TOILET_DETAILS = "toiletDetails"

        val database = Room.databaseBuilder(MyApp.instance.applicationContext, MyDatabase::class.java, DATABASE_NAME)
            .build()
    }
}