package com.example.e_commerceproject.Settings.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.e_commerceproject.AboutFragment
import com.example.e_commerceproject.R
import com.example.e_commerceproject.address.view.view.AddressFragment
import com.example.e_commerceproject.currencyConverter.view.CurrencydiologFragment
import com.example.e_commerceproject.profile.view.ProfileFragment

class SettingsFragment : Fragment() {

    lateinit var backArrow: ImageView
    lateinit var settingsFragmentView: View
    lateinit var addressArrow: ImageView
    lateinit var navigateToAddressScreenBtn: ImageView
    lateinit var navigateToCurrencyScreenBtn: ImageView
    lateinit var navigateToContactusScreenBtn: ImageView
    lateinit var navigateToaboutScreenBtn: ImageView
    lateinit var logoutButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        settingsFragmentView = inflater.inflate(R.layout.fragment_settings, container, false)
        return settingsFragmentView
        // Inflate the layout for this fragment

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        backArrow= settingsFragmentView.findViewById(R.id.settingArrowBack)
        backArrow.setOnClickListener(View.OnClickListener {
            val profileFragment = ProfileFragment()
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView,profileFragment )?.commit()
            Toast.makeText(requireContext() ,"uyuyhfuyu" , Toast.LENGTH_SHORT ).show()

        })
        addressArrow= settingsFragmentView.findViewById(R.id.navigateToAddressScreenBtn)
        addressArrow.setOnClickListener(View.OnClickListener {
            val fragmentManager=parentFragmentManager
            val fragmentTransaction=fragmentManager.beginTransaction()

            //  fragmentTransaction.replace(R.id.,fragment)
            fragmentTransaction.commit()
        })

        navigateToAddressScreenBtn = settingsFragmentView.findViewById(R.id.navigateToAddressScreenBtn)
        navigateToAddressScreenBtn.setOnClickListener {

            val addressFragment = AddressFragment()
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView, addressFragment)?.commit()
            Toast.makeText(requireContext() ,"uyuyhfuyu" , Toast.LENGTH_SHORT ).show()

        }


        navigateToCurrencyScreenBtn = settingsFragmentView.findViewById(R.id.navigateToCurrencyScreenBtn)
        navigateToCurrencyScreenBtn.setOnClickListener {

            val currency_fragment =CurrencydiologFragment()
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView, currency_fragment)?.commit()
            Toast.makeText(requireContext() ,"currency dialog" , Toast.LENGTH_SHORT ).show()
        }
        navigateToContactusScreenBtn = settingsFragmentView.findViewById(R.id.navigateToContactusScreenBtn)
        navigateToContactusScreenBtn.setOnClickListener {

//            val profileFragment = ProfileFragment()
//            fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView, profileFragment)?.commit()
            Toast.makeText(requireContext() ,"uyuyhfuyu" , Toast.LENGTH_SHORT ).show()

        }
        navigateToaboutScreenBtn = settingsFragmentView.findViewById(R.id.navigateToaboutScreenBtn)
        navigateToaboutScreenBtn.setOnClickListener {

            val about_fragment = AboutFragment()
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView,about_fragment )?.commit()
            Toast.makeText(requireContext() ,"uyuyhfuyu" , Toast.LENGTH_SHORT ).show()
        }
        logoutButton = view.findViewById(R.id.logoutButton)
        logoutButton.setOnClickListener {

            val sharedPreferences : SharedPreferences = requireContext().getSharedPreferences("loginsharedprefs" ,
                Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.apply(){
                putString("EMAIL_LOGIN" ,  "")
                putString("PASSWORD_LOGIN" ,  "")
            }.apply()
            Toast.makeText(requireContext() ,"logout" , Toast.LENGTH_SHORT ).show()
        }
    }


}
