package com.example.win9

import android.os.Bundle
import android.provider.ContactsContract.Directory
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.win9.adapters.PlayersAdapter
import com.example.win9.model.BestPlayer
import com.example.win9.model.PlayersModel
import com.example.win9.presenters.PlayersPresenter
import com.example.win9.views.PlayersView
import kotlinx.android.synthetic.main.fragment_players.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter


class PlayersFragment : MvpAppCompatFragment(), PlayersView {

    @InjectPresenter
    lateinit var playersPresenter: PlayersPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_players, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            playersPresenter.requestApi()
        }
    }

    override fun onCompleteDataApi(playersModel: PlayersModel) {
        Log.d("BODY", playersModel.bestPlayers.toString())
        val list = ArrayList<BestPlayer>()
        for (i in playersModel.bestPlayers){
            list.add(i)
        }
        CoroutineScope(Dispatchers.Main).launch{
            val recyclerView = recycler_view_players
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = PlayersAdapter(list)
        }

    }

    override fun onErrorDataApi(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }

}