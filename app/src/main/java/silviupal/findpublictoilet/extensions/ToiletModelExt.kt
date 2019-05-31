package silviupal.findpublictoilet.extensions

import android.content.Context
import android.location.Address
import silviupal.findpublictoilet.firebase.model.ToiletModel
import android.location.Geocoder
import java.util.Locale

/**
 * Created by Silviu Pal on 5/26/2019.
 */
fun ToiletModel.getAddress(context: Context?): String {
    context?.let {
        val geocoder = Geocoder(it, Locale.getDefault())
        val addresses: List<Address> = geocoder.getFromLocation(this.latitude.toDouble(),
            this.longitude.toDouble(), 1)
        if (addresses.isNotEmpty()) {
            return addresses[0].getAddressLine(0)
        }
    }
    return ""
    /*val geocoder: Geocoder
    val addresses: List<Address>
    geocoder = Geocoder(this, Locale.getDefault())

    addresses = geocoder.getFromLocation(latitude,
        longitude,
        1) // Here 1 represent max location result to returned, by documents it recommended 1 to 5

    val address = addresses[0].getAddressLine(0) // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
    val city = addresses[0].getLocality()
    val state = addresses[0].getAdminArea()
    val country = addresses[0].getCountryName()
    val postalCode = addresses[0].getPostalCode()
    val knownName = addresses[0].getFeatureName() // Only if available else return NULL*/
}