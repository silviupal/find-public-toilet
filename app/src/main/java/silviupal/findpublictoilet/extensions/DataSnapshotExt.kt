package silviupal.findpublictoilet.extensions

import com.google.firebase.database.DataSnapshot
import silviupal.findpublictoilet.firebase.model.ToiletModel

/**
 * Created by Silviu Pal on 5/30/2019.
 */
fun DataSnapshot.convertToToilets(): List<ToiletModel> {
    var toilets = emptyList<ToiletModel>()
    this.children.forEach {
        val value = it.getValue(ToiletModel::class.java)
        value?.let {
            toilets = toilets + it
        }
    }
    return toilets
}