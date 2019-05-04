package silviupal.findpublictoilet

import android.Manifest
import android.content.Context
import androidx.fragment.app.Fragment
import pub.devrel.easypermissions.EasyPermissions

/**
 * Created by Silviu Pal on 4/27/2019.
 */
object MyPermissions {
    fun hasPermission(permission: String): Boolean =
        EasyPermissions.hasPermissions(MyApp.instance.applicationContext, permission)

    fun isPermanentlyDenied(context:Fragment, permission: String): Boolean =
        EasyPermissions.permissionPermanentlyDenied(context, permission)

}