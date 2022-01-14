package com.example.simpleofflinecaching.feature.restsurants

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import android.view.Menu
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpleofflinecaching.adapter.RestaurantAdapterList
import com.example.simpleofflinecaching.R
import com.example.simpleofflinecaching.databinding.ActivityRestaurantBinding
import com.example.simpleofflinecaching.util.Resource
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RestaurantActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityRestaurantBinding


    private val viewmodel: RestaurantViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRestaurantBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val recadapter = RestaurantAdapterList();
        binding.apply {
            recycler.apply {
                adapter = recadapter
                layoutManager = LinearLayoutManager(this@RestaurantActivity)
            }


            viewmodel.restaurantFromRepo.observe(this@RestaurantActivity) { result ->
                recadapter.submitList(result.data)

                progressbar.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                errormessage.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
                errormessage.text = result.error?.localizedMessage
            }

        }


//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        appBarConfiguration = AppBarConfiguration(navController.graph)
//        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        return when (item.itemId) {
//            R.id.action_settings -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
//
//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.nav_host_fragment_content_main)
//        return navController.navigateUp(appBarConfiguration)
//                || super.onSupportNavigateUp()
//    }
}