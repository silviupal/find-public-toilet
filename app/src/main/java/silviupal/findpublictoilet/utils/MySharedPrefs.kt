package silviupal.findpublictoilet.utils

import android.content.Context
import androidx.core.content.edit
import silviupal.findpublictoilet.MyApp
import silviupal.findpublictoilet.MyConstants

/**
 * Created by Silviu Pal on 4/27/2019.
 */
object MySharedPrefs {
    private val prefs = MyApp.instance.applicationContext.getSharedPreferences(MyConstants.SHARED_PREFS,
        Context.MODE_PRIVATE)

    fun putBool(key: String, value: Boolean) {
        prefs.edit {
            putBoolean(key, value)
        }
    }

    fun getBool(key: String, defaultValue: Boolean): Boolean = prefs.getBoolean(key, defaultValue)
}