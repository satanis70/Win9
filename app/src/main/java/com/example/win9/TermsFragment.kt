package com.example.win9

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.win9.adapters.PlayersAdapter
import com.example.win9.adapters.TermsAdapter
import com.example.win9.model.Term
import com.example.win9.model.TermsModel
import com.example.win9.presenters.TermsPresenter
import com.example.win9.views.TermsView
import kotlinx.android.synthetic.main.fragment_players.*
import kotlinx.android.synthetic.main.fragment_terms.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter

class TermsFragment : MvpAppCompatFragment(), TermsView {

    @InjectPresenter
    lateinit var termsPresenter: TermsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_terms, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            termsPresenter.requestApi()
        }

    }

    override fun onCompleteDataApi(termsModel: TermsModel) {
        Log.d("TERMS", termsModel.terms.toString())
        val list = ArrayList<Term>()
        for (i in termsModel.terms){
            list.add(i)
        }
        CoroutineScope(Dispatchers.Main).launch{
            val recyclerView = recycler_view_terms
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = TermsAdapter(list)
        }
    }

    override fun onErrorDataApi(error: String) {
        Toast.makeText(requireContext(), error, Toast.LENGTH_SHORT).show()
    }
}