package silviupal.findpublictoilet

import android.app.Application
import com.google.firebase.FirebaseApp

/**
 * Created by Silviu Pal on 4/26/2019.
 */
class MyApp : Application() {
    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }

    companion object {
        lateinit var instance: MyApp
    }
}