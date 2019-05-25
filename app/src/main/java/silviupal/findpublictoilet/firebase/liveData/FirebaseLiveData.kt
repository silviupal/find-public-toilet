package silviupal.findpublictoilet.firebase.liveData

import androidx.constraintlayout.solver.widgets.Snapshot
import androidx.lifecycle.LiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.Query
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import silviupal.findpublictoilet.firebase.model.ToiletModel

/**
 * Created by Silviu Pal on 5/13/2019.
 */
class FirebaseLiveData() : LiveData<DataSnapshot>() {
    private lateinit var query: Query
    private val listener = MyValueEventListener()

    constructor(query: Query) : this() {
        this.query = query
    }

    constructor(ref: DatabaseReference) : this() {
        this.query = ref
    }

    override fun onActive() {
        super.onActive()
        query.addValueEventListener(listener)
    }

    override fun onInactive() {
        super.onInactive()
        query.removeEventListener(listener)
    }

    inner class MyValueEventListener : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            value = dataSnapshot
        }

        override fun onCancelled(databaseError: DatabaseError) {
            // TODO Treat error
        }
    }
}