package silviupal.findpublictoilet.firebase.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.FirebaseDatabase
import silviupal.findpublictoilet.base.BaseFirebaseVM
import silviupal.findpublictoilet.firebase.model.ToiletModel

/**
 * Created by Silviu Pal on 4/30/2019.
 */
class MyToiletsVM : BaseFirebaseVM<LiveData<List<ToiletModel>>>(FirebaseDatabase.getInstance().getReference("/toilets")) {

    override fun getLiveData(): LiveData<List<ToiletModel>> = convertData(liveData.value)

    override fun convertData(dataSnapshot: DataSnapshot?): LiveData<List<ToiletModel>> {
        var list = emptyList<ToiletModel>()
        dataSnapshot?.children?.forEach {
            val value = it.getValue(ToiletModel::class.java)
            value?.let {
                list = list + it
            }
        }

        return MutableLiveData<List<ToiletModel>>().apply {
            value = list
        }
    }
}