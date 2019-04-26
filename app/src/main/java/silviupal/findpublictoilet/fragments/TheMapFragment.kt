package silviupal.findpublictoilet.fragments

import android.os.Bundle
import android.view.View
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_maps.*
import silviupal.findpublictoilet.R
import silviupal.findpublictoilet.base.BaseFragment

/**
 * Created by Silviu Pal on 4/26/2019.
 */
class TheMapFragment : BaseFragment(), OnMapReadyCallback {
    override fun getLayoutId(): Int = R.layout.fragment_maps

    private lateinit var mMap: GoogleMap

    override fun setupToolbar() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        map.onCreate(savedInstanceState)
        map.onResume()
        map.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }
}