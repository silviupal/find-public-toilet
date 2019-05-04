package silviupal.findpublictoilet.utils

import android.content.Context
import android.content.DialogInterface
import android.view.View
import androidx.appcompat.app.AlertDialog
import silviupal.findpublictoilet.R

/**
 * Created by Silviu Pal on 4/10/2019.
 */
object DialogUtils {
    fun buildDialogWithListeners(context: Context,
        title: String,
        message: String,
        positiveButton: Pair<String, DialogInterface.OnClickListener>,
        negativeButton: Pair<String, DialogInterface.OnClickListener>): AlertDialog.Builder {
        return AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton(positiveButton.first, positiveButton.second)
            .setNegativeButton(negativeButton.first, negativeButton.second)
    }

    fun buildNormalAlertDialog(context: Context,
        title: String,
        message: String,
        positiveButton: Pair<String, DialogInterface.OnClickListener>): AlertDialog.Builder {
        return AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton(positiveButton.first, positiveButton.second)
            .setNegativeButton(context.getString(R.string.cancel), null)
    }

    fun buildNoMessageNoTitleAlertDialog(context: Context): AlertDialog.Builder {
        return AlertDialog.Builder(context)
            .setCancelable(false)
            .setPositiveButton(context.getString(R.string.yes), null)
            .setNegativeButton(context.getString(R.string.cancel), null)
    }

    fun buildInfoDialog(context: Context, title: String, message: String): AlertDialog.Builder {
        return AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(message)
            .setCancelable(false)
            .setPositiveButton(context.getString(R.string.ok), null)
    }
}