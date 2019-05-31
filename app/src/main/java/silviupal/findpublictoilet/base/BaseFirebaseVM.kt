package silviupal.findpublictoilet.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import silviupal.findpublictoilet.firebase.liveData.FirebaseLiveData

/**
 * Created by Silviu Pal on 5/13/2019.
 */
abstract class BaseFirebaseVM : ViewModel() {
    abstract val query: DatabaseReference

    val liveData: FirebaseLiveData
        get() = FirebaseLiveData(query)
}