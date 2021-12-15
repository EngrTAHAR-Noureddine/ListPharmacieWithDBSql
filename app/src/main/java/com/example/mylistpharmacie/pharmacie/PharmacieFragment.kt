package com.example.mylistpharmacie.pharmacie

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mylistpharmacie.R

class PharmacieFragment : Fragment() {

    companion object {
        fun newInstance() = PharmacieFragment()
    }

    private lateinit var viewModel: PharmacieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.pharmacie_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PharmacieViewModel::class.java)
        // TODO: Use the ViewModel
    }

}