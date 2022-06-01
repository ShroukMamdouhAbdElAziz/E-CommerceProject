package com.example.e_commerceproject.home.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.e_commerceproject.R
import com.example.e_commerceproject.brands.view.BrandsFragment
import com.example.e_commerceproject.details.view.DetailsFragment
import com.example.e_commerceproject.home.model.DummyData
import com.example.e_commerceproject.profile.view.ProfileFragment


class HomeFragment : Fragment() , OnBrandClickListener{


    lateinit var recyclerView: RecyclerView
    lateinit var brandsAdapter: BrandsAdapter
    lateinit var homeFragmentView: View
    lateinit var brandLogo: ImageView
    lateinit var profileScreen: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {

        // Inflate the layout for this fragment
        homeFragmentView = inflater.inflate(R.layout.fragment_home, container, false)
        return homeFragmentView

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView=view.findViewById(R.id.brandsRecycleView)
        val brandsLinearLayoutManager: LinearLayoutManager = LinearLayoutManager(context)
        brandsLinearLayoutManager.orientation= RecyclerView.HORIZONTAL
        brandsAdapter= BrandsAdapter(requireContext(), this)
        brandsAdapter.setDataList(DummyData.BRAND_DATA)
        recyclerView.layoutManager=brandsLinearLayoutManager
        recyclerView.adapter=brandsAdapter

        profileScreen=view.findViewById(R.id.profileIconScreen)

        profileScreen.setOnClickListener(View.OnClickListener {
            val fragmentManager=parentFragmentManager
            val fragmentTransaction=fragmentManager.beginTransaction()

            val profileFragment = ProfileFragment()
            fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView, profileFragment)?.commit()
            Toast.makeText(requireContext() ,"uyuyhfuyu" , Toast.LENGTH_SHORT ).show()

//          fragmentTransaction.replace(R.id.fragment)
//            fragmentTransaction.commit()
        })

//        brandLogo =homeFragmentView.findViewById(R.id.brandlogo)
//        brandLogo.setOnClickListener(View.OnClickListener {
//            Toast.makeText(requireContext() , "jjk" , Toast.LENGTH_SHORT).show()
//            val fragmentManager=parentFragmentManager
//            val fragmentTransaction=fragmentManager.beginTransaction()
//
////            fragmentTransaction.replace(R.id.,fragment)
//            fragmentTransaction.commit()
//
//        })

    }

    override fun OnBrandClick() {
        val brandsFragment = BrandsFragment()
        fragmentManager?.beginTransaction()?.replace(R.id.fragmentContainerView, brandsFragment)?.commit()
        Toast.makeText(requireContext() ,"uyuyhfuyu" , Toast.LENGTH_SHORT ).show()
    }


}