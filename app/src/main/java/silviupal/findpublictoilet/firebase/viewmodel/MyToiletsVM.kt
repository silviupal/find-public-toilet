package silviupal.findpublictoilet.firebase.viewmodel

import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import silviupal.findpublictoilet.base.BaseFirebaseVM
import silviupal.findpublictoilet.firebase.liveData.FirebaseLiveData

/**
 * Created by Silviu Pal on 4/30/2019.
 */
class MyToiletsVM : BaseFirebaseVM() {
    override val query: DatabaseReference
        get() = FirebaseDatabase.getInstance().getReference("/toilets")
}