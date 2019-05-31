package silviupal.findpublictoilet.fragments

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.database.DataSnapshot
import kotlinx.android.synthetic.main.fragment_maps.*
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions
import silviupal.findpublictoilet.BuildConfig
import silviupal.findpublictoilet.MyPermissions
import silviupal.findpublictoilet.R
import silviupal.findpublictoilet.base.BaseFragment
import silviupal.findpublictoilet.extensions.convertToToilets
import silviupal.findpublictoilet.extensions.getAddress
import silviupal.findpublictoilet.extensions.showToast
import silviupal.findpublictoilet.firebase.model.ToiletModel
import silviupal.findpublictoilet.firebase.viewmodel.MyToiletsVM
import silviupal.findpublictoilet.utils.DialogUtils

/**
 * Created by Silviu Pal on 4/26/2019.
 */
class TheMapFragment : BaseFragment(), OnMapReadyCallback, EasyPermissions.PermissionCallbacks {
    override fun getLayoutId(): Int = R.layout.fragment_maps

    private lateinit var mMap: GoogleMap

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapView.onCreate(savedInstanceState)
        mapView.onResume()
        mapView.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        setLocationButtonListener()
        checkForPermission()
        setupMapSettings()
        setupObservers()
        animateCameraToMyCurrentPosition()
    }

    private fun setLocationButtonListener() {
        mMap.setOnMyLocationButtonClickListener(object : GoogleMap.OnMyLocationButtonClickListener {
            override fun onMyLocationButtonClick(): Boolean {
                context?.let {
                    val lm = it.getSystemService(Context.LOCATION_SERVICE) as LocationManager
                    if (!lm.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                        it.showToast(getString(R.string.toast_no_location_info))
                        return true
                    }
                }
                return false // default behaviour
            }
        })
    }

    @SuppressLint("MissingPermission")
    private fun checkForPermission() {
        if (MyPermissions.hasPermission(Manifest.permission.ACCESS_FINE_LOCATION)) {
            mMap.isMyLocationEnabled = true
        } else {
            showLocationInfoDialog()
        }
    }

    private fun setupMapSettings() {
        with(mMap.uiSettings) {
            isZoomControlsEnabled = true
            isCompassEnabled = true
            isMyLocationButtonEnabled = true
            isIndoorLevelPickerEnabled = true
            isMapToolbarEnabled = true
            isZoomGesturesEnabled = true
            isScrollGesturesEnabled = true
            isTiltGesturesEnabled = true
            isRotateGesturesEnabled = true
        }
    }

    private fun setupObservers() {
        val model = ViewModelProviders.of(this).get(MyToiletsVM::class.java)
        model.liveData.observe(this, Observer<DataSnapshot> { dataSnapshot ->
            context?.showToast("List taken from DB")
            addMarkers(dataSnapshot.convertToToilets())
        })
    }

    private fun addMarkers(toilets: List<ToiletModel>) {
        mMap.clear()
        toilets.forEach { toilet ->
            val toiletOnMap = LatLng(toilet.latitude.toDouble(), toilet.longitude.toDouble())
            mMap.addMarker(MarkerOptions().position(toiletOnMap).title(toilet.getAddress(context)))
        }
    }

    @SuppressLint("MissingPermission")
    private fun animateCameraToMyCurrentPosition() {
        if (MyPermissions.hasPermission(Manifest.permission.ACCESS_FINE_LOCATION) && mMap.isMyLocationEnabled) {
            activity?.let {
                val fusedLocationClient = LocationServices.getFusedLocationProviderClient(it)
                fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                    location?.let {
                        val cameraPosition = CameraPosition.Builder()
                            .target(LatLng(location.latitude, location.longitude))
                            .zoom(15f)
                            .build()
                        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
                    }
                }
            }
        }
    }

    private fun showLocationInfoDialog() {
        context?.let {
            DialogUtils.buildDialogWithListeners(it,
                title = getString(R.string.dialog_info_location_title),
                message = getString(R.string.dialog_info_location_message),
                positiveButton = Pair(it.getString(R.string.yes),
                    DialogInterface.OnClickListener { _, _ ->
                        enableMyLocation()
                    }),
                negativeButton = Pair(it.getString(R.string.exit),
                    DialogInterface.OnClickListener { _, _ ->
                        activity?.finish()
                    })
            ).show()
        }
    }

    @AfterPermissionGranted(REQUEST_CODE_LOCATION)
    private fun enableMyLocation() {
        if (MyPermissions.isPermanentlyDenied(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            startActivity(Intent().apply {
                action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                data = Uri.fromParts("package", BuildConfig.APPLICATION_ID, null)
            })
        } else {
            EasyPermissions.requestPermissions(this, getString(R.string.dialog_need_location_permission_message),
                REQUEST_CODE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION
            )
        }
    }

    /** Override the onRequestPermissionResult to use EasyPermissions */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    @SuppressLint("MissingPermission")
    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        mMap.isMyLocationEnabled = true
    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
    }

    companion object {
        private const val REQUEST_CODE_LOCATION = 123
    }
}