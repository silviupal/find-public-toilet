package silviupal.findpublictoilet.extensions

import android.content.Context
import android.widget.Toast

/**
 * Created by Silviu Pal on 4/29/2019.
 */
fun Context.showToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}