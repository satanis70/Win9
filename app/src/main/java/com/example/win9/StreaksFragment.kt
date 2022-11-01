package com.example.win9

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.win9.adapters.StreakAdapter
import com.example.win9.model.Streak
import com.example.win9.model.StreaksModel
import com.example.win9.presenters.StreakPresenter
import com.example.win9.views.StreakView
import kotlinx.android.synthetic.main.fragment_streaks.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter


class StreaksFragment : MvpAppCompatFragment(), StreakView {

    @InjectPresenter
    lateinit var streakPresenter: StreakPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_streaks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            streakPresenter.requestApi()
        }
    }

    override fun onCompleteDataApi(streaksModel: StreaksModel) {
        Log.i("STREAK", streaksModel.streaks.toString())
        val list = ArrayList<Streak>()
        for (i in streaksModel.streaks){
            list.add(i)
        }
        CoroutineScope(Dispatchers.Main).launch{
            val recyclerView = recycler_view_streak
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = StreakAdapter(list)
        }
    }

    override fun onErrorDataApi(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }
}