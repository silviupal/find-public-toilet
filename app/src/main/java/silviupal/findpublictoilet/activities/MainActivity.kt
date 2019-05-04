package silviupal.findpublictoilet.activities

import android.os.Bundle
import com.mikepenz.materialdrawer.Drawer
import kotlinx.android.synthetic.main.activity_main.*
import silviupal.findpublictoilet.R
import silviupal.findpublictoilet.base.BaseActivity
import silviupal.findpublictoilet.fragments.TheMapFragment

class MainActivity : BaseActivity() {
    private lateinit var drawer: Drawer

    override fun getLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)
        setDrawer()
        setMapFragment()
    }

    private fun setMapFragment() {
        switchFragment(TheMapFragment())
    }

    private fun setDrawer() {
        /*val writeAPostItem = PrimaryDrawerItem().withIdentifier(1)
            .withIcon(R.drawable.ic_write_post)
            .withSelectedIcon(R.drawable.ic_write_post_selected)
            .withName(R.string.toolbar_title_write_a_post_fragment)
        val yourPostsItem = PrimaryDrawerItem().withIdentifier(2)
            .withIcon(R.drawable.ic_your_posts)
            .withSelectedIcon(R.drawable.ic_your_posts_selected)
            .withName(R.string.toolbar_title_your_posts)
        val yourHashtagsItem = PrimaryDrawerItem().withIdentifier(3)
            .withIcon(R.drawable.ic_your_hashtags)
            .withSelectedIcon(R.drawable.ic_your_hashtags_selected)
            .withName(R.string.toolbar_title_your_hashtags)
        val aboutItem = PrimaryDrawerItem().withIdentifier(4)
            .withIcon(R.drawable.ic_about)
            .withSelectedIcon(R.drawable.ic_about_selected)
            .withName(R.string.toolbar_title_about)
        val rateAppItem = PrimaryDrawerItem().withIdentifier(5)
            .withIcon(R.drawable.ic_rating)
            .withSelectable(false)
            .withName(R.string.toolbar_title_rate_the_app)

        drawer = DrawerBuilder().withActivity(this)
            .withToolbar(toolbar)
            .withStickyHeader(R.layout.drawer_header_layout)
            .addDrawerItems(writeAPostItem, yourPostsItem, yourHashtagsItem)
            .build()

        drawer.addStickyFooterItem(aboutItem)
        drawer.addStickyFooterItem(DividerDrawerItem())
        drawer.addStickyFooterItem(rateAppItem)

        drawer.onDrawerItemClickListener = Drawer.OnDrawerItemClickListener { view, _, drawerItem ->
            drawer.closeDrawer()
            KeyboardUtils.hideKeyboard(view, this)
            when (drawerItem.identifier) {
                1L -> {
                    if (selectedDrawerItem != 1L) {
                        selectedDrawerItem = 1L
                        switchFragment(writeAPostFragment)
                    }
                }
                2L -> {
                    if (selectedDrawerItem != 2L) {
                        selectedDrawerItem = 2L
                        switchFragment(YourPostsFragment())
                    }
                }
                3L -> {
                    if (selectedDrawerItem != 3L) {
                        selectedDrawerItem = 3L
                        switchFragment(YourHashtagsFragment())
                    }
                }
                4L -> {
                    if (selectedDrawerItem != 4L) {
                        selectedDrawerItem = 4L
                        switchFragment(aboutFragment)
                    }
                }
                5L -> {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse("https://play.google.com/store/apps/details?id=silviupal.hashtagscounter")
                    startActivity(intent)
                }
            }
            true
        }*/
    }

    override fun onBackPressed() {
        if (::drawer.isInitialized && drawer.isDrawerOpen) {
            drawer.closeDrawer()
        } else {
            super.onBackPressed()
        }
    }
}
