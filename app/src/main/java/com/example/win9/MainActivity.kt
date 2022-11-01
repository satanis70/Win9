package com.example.win9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.win9.model.PlayersModel
import com.example.win9.presenters.PlayersPresenter
import com.example.win9.views.PlayersView
import com.onesignal.OneSignal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter
import nl.joery.animatedbottombar.AnimatedBottomBar

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId("714b9f14-381d-4fc4-a93c-28d480557381")
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.frame_layout_container) as NavHostFragment
        val navController = navHostFragment.navController
        val buttomBar = findViewById<AnimatedBottomBar>(R.id.bottom_bar)
        buttomBar.onTabSelected = {
            Log.i("TAB", it.title)
            if (it.title=="Best players"){
                navController.navigate(R.id.playersFragment)
            } else if (it.title=="Terms"){
                navController.navigate(R.id.termsFragment)
            } else if(it.title=="The longest streaks"){
                navController.navigate(R.id.streaksFragment)
            }
        }

    }
}