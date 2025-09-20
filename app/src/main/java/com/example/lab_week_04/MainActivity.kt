package com.example.lab_week_04

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set toolbar
        setSupportActionBar(findViewById(R.id.toolbar))

        // Ambil NavController dari NavHostFragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Set top-level destinations (yang tidak menampilkan tombol "back")
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.listFragment,
                R.id.favoritesFragment
            ), findViewById(R.id.drawer_layout)
        )

        // Hubungkan toolbar dengan navController
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Hubungkan NavigationView dengan navController
        findViewById<NavigationView>(R.id.nav_view)
            ?.setupWithNavController(navController)
    }

    // Agar tombol "Up" toolbar bekerja
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
