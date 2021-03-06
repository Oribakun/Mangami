package com.mangami.mangami

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.view.MenuItem
import android.widget.FrameLayout

import fragment.HomeFragment
import fragment.FragmentBooklist
import fragment.FragmentRecent
import fragment.FragmentDownloads
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.toast
import android.widget.RadioButton
import com.mangami.mangami.R.mipmap.ic_launcher
import android.widget.ImageButton







class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var content: FrameLayout? = null

    private lateinit var mDrawerLayout: DrawerLayout


//    BOTTOM NAVIGATION VIEW

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->


        //        This Part disables the Shifting in the BottomNavigation
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation)
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView)


//        What happens when the BottomNavigation Items are clicked is written here
        when (item.itemId) {
            R.id.navigation_home -> {

                val fragment = HomeFragment.Companion.newInstance()
                addFragment(fragment)



                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_booklist -> {

                val fragment = FragmentBooklist.Companion.newInstance()
                addFragment(fragment)



                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_recent -> {

                val fragment = FragmentRecent.Companion.newInstance()
                addFragment(fragment)



                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_downloads -> {

                val fragment = FragmentDownloads.Companion.newInstance()
                addFragment(fragment)



                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }


//    The method to add, animate and change between Fragments:

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.design_snackbar_in, R.anim.design_snackbar_out)
                .replace(R.id.content, fragment, fragment.javaClass.getSimpleName())
                .addToBackStack(fragment.javaClass.getSimpleName())
                .commit()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView: BottomNavigationView
        bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation)


//        This selects the menu which should open first in the BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        bottomNavigationView.selectedItemId = R.id.navigation_home


//        This is important so the Frame named "content" will be set

        content = findViewById(R.id.content) as FrameLayout
        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


//        SetActionBarSupport DOES NOT WORK IN FRAGMENTS??!?!?!

        mDrawerLayout = findViewById(R.id.drawer_layout)

        setSupportActionBar(findViewById(R.id.toolbar_main))


        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.toolbar_logo)


        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar_main, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        for (i in 0 until toolbar_main.getChildCount()) {
            if (toolbar_main.getChildAt(i) is ImageButton) {
                val imageButton = toolbar_main.getChildAt(i) as ImageButton
                imageButton.setPadding(16, 100, 0, 100)
            }
        }


        nav_view.setNavigationItemSelectedListener(this)

    }

////
////    ACTION BAR
////
//
////    This adds items to the ActionBar
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.menu_toolbar_home, menu)
//        return true
//    }
//
//
////    This is the OnClickListener for the Buttons in the ActionBar
//    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
//    R.id.toolbar_edit -> {
//
//
//        true
//    }
//
//    R.id.toolbar_search -> {
//
//
//        true
//    }
//
//    else -> {
//        // If we got here, the user's action was not recognized.
//        // Invoke the superclass to handle it.
//        super.onOptionsItemSelected(item)
//    }
//}
////
////    ACTION BAR CLOSED
////





    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle menu_bottom_navigation view item clicks here.

        when (item.itemId) {
            R.id.nav_manage_account -> {

                toast("Manage Account Test Worked WOrked worKED")


            }
            R.id.nav_backup_restore -> {

                toast("2 Test Worked")


            }
            R.id.nav_anime -> {

                toast("3 Test Worked")


            }
            R.id.nav_manga -> {

                toast("4 Test Worked")


            }
            R.id.nav_artworks -> {

                toast("5 Test Worked")


            }
            R.id.nav_whats_new -> {

                toast("6 Test Worked")


            }
            R.id.nav_feedback -> {

                toast("7 Test Worked")


            }
            R.id.nav_about_us -> {

                toast("8 Test Worked")


            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)

        return true
    }


}

