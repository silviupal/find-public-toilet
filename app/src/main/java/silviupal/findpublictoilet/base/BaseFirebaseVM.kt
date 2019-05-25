package silviupal.findpublictoilet.base

import androidx.lifecycle.ViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseReference
import silviupal.findpublictoilet.firebase.liveData.FirebaseLiveData

/**
 * Created by Silviu Pal on 5/13/2019.
 */
abstract class BaseFirebaseVM<out T>(reference: DatabaseReference) : ViewModel() {
    protected val liveData = FirebaseLiveData(reference)

    abstract fun getLiveData(): T

    abstract fun convertData(dataSnapshot: DataSnapshot?): T
}