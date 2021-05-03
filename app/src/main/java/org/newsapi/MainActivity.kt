package org.newsapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import org.newsapi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_top_headlines, R.id.navigation_explore, R.id.navigation_saved
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding?.bottomNavigationView?.setupWithNavController(navController)
        binding?.bottomNavigationView?.setOnNavigationItemReselectedListener {
            // Do nothing to ignore the reselection
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}