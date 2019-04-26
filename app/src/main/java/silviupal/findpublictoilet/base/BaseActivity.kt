package silviupal.findpublictoilet.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import silviupal.findpublictoilet.R

/**
 * Created by Silviu Pal on 05/04/2019.
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
    }

    @LayoutRes
    abstract fun getLayoutId(): Int

    fun switchFragment(fragment: BaseFragment) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(0, 0)
            .replace(R.id.container, fragment)
            .commit()
    }
}
