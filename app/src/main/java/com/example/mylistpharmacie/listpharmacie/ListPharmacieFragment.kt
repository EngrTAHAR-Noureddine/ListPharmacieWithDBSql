package com.example.mylistpharmacie.listpharmacie

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mylistpharmacie.R
import com.example.mylistpharmacie.databinding.ListPharmacieFragmentBinding
import com.example.mylistpharmacie.db.PharmacieDB

class ListPharmacieFragment : Fragment() {



    private lateinit var viewModel: ListPharmacieViewModel
    private lateinit var modelFactory: ListPharmacieFactory
    private lateinit var binding: ListPharmacieFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        this.binding = DataBindingUtil.inflate(
            inflater,
            R.layout.list_pharmacie_fragment,
            container,
            false
        )

        val application = requireNotNull(this.activity).application

        val dataSource = PharmacieDB.getInstance(application)?.PharmacieDao()!!

        val viewModelFactory = ListPharmacieFactory(dataSource,this.requireContext())


        val pharmacieViewModel = ViewModelProvider(this, viewModelFactory).get(ListPharmacieViewModel::class.java)




        binding.listPharmacies = pharmacieViewModel
        // binding.setLifecycleOwner(this)
        binding.lifecycleOwner = this
        //setHasOptionsMenu(true)

        this.binding.recyclerView.layoutManager = LinearLayoutManager(activity)

        pharmacieViewModel.pharmacies.observe(
            viewLifecycleOwner, Observer {
                it?.let{
                    this.binding.recyclerView.adapter = MyAdapter(activity,it)
                }
            }
        )




        return this.binding.root
    }



}