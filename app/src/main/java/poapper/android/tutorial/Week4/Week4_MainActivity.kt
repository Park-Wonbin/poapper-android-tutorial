package poapper.android.tutorial.Week4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.week4_main.*
import poapper.android.tutorial.R

class Week4_MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private var drawerToggle: ActionBarDrawerToggle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.week4_main)

        setSupportActionBar(toolBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        drawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolBar, 0, 0)
        drawerLayout.addDrawerListener(drawerToggle!!)
        drawerToggle!!.syncState()

        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.week4_toolbar_action, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_filter -> {
                Toast.makeText(applicationContext, "Filter!", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_settings -> {
                Toast.makeText(applicationContext, "Settings!", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.action_info -> {
                Toast.makeText(applicationContext, "Info!", Toast.LENGTH_SHORT).show()
                return true
            }
            else -> {
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.menu1 -> Toast.makeText(this, "Menu1 clicked...!", Toast.LENGTH_SHORT).show()
            // ....
        }

        drawerLayout.closeDrawer(GravityCompat.START)
        return false
    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
