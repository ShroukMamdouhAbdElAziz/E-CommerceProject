package com.example.e_commerceproject.currencyConverter.view

import android.content.ContentValues
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.e_commerceproject.R
import com.example.e_commerceproject.Settings.view.SettingsFragment
import com.example.e_commerceproject.currencyConverter.viewModel.ConverterViewModel
import com.example.e_commerceproject.currencyConverter.viewModel.ConverterViewModelFactory
import com.example.e_commerceproject.network.ConverterRepository
import com.example.e_commerceproject.network.remotesource.RemoteSourceClass


const val SHARD_NAME = "shard"
const val CURRUNEY_TYPE = "currency"


class CurrencydiologFragment : Fragment() {

    lateinit var CviewModel: ConverterViewModel
    lateinit var VFactory: ConverterViewModelFactory
    lateinit var Egp_currency: Button
    lateinit var USD_currency: Button

    lateinit var ok_btn: Button
    lateinit var sharedPref: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {


        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var currency_frag = inflater.inflate(R.layout.fragment_currency_dialog, container, false)
        Egp_currency = currency_frag.findViewById(R.id.Egp_currency)
        USD_currency = currency_frag.findViewById(R.id.Usd_currency)
        ok_btn = currency_frag.findViewById(R.id.btn_ok)
        return currency_frag
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val sharedPref =
            requireActivity().getSharedPreferences(SHARD_NAME, Context.MODE_PRIVATE) ?: return
        with(sharedPref.edit()) {
            putString(CURRUNEY_TYPE, "EGP")
            commit()
        }

        when (CURRUNEY_TYPE) {
            "EGP" -> {
                Egp_currency!!.isClickable = true
            }

            "USD" -> {
                USD_currency!!.isClickable = true
            }
        }
        Egp_currency?.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                //     changeCurrency("EGP")
            }
        })

        USD_currency.setOnClickListener(object : View.OnClickListener { override fun onClick(view: View?) {
//
            //                changeCurrency("USD")
        }
        })

        ok_btn.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {


                VFactory = ConverterViewModelFactory(
                    ConverterRepository.getInstance(

                        RemoteSourceClass.getInstance(),
                        requireContext()

                    )
                )

                CviewModel = ViewModelProvider(this@CurrencydiologFragment, VFactory).get(
                    ConverterViewModel::class.java
                )

                CviewModel.getcontvertedResponse()
                CviewModel._Convert_Response.observe(viewLifecycleOwner) { respo ->
                    Log.i(ContentValues.TAG, "onChanged: ${respo.result}")
                    System.out.println("Re"+respo.result)

                    val settingsFragment = SettingsFragment()
                    fragmentManager?.beginTransaction()
                        ?.replace(R.id.fragmentContainerView, settingsFragment)
                        ?.commit()
                    Toast.makeText(
                        requireContext(),
                        "come back from cuurency dialog",
                        Toast.LENGTH_SHORT
                    ).show()

                }
            }})
    }}