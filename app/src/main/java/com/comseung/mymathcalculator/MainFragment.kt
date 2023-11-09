package com.comseung.mymathcalculator

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.comseung.mymathcalculator.databinding.FragmentMainBinding

class MainFragment: BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            goNumbertheoryBtn.setOnClickListener { btn ->
                val action = MainFragmentDirections.actionMainFragmentToNumberTheoryFragment()
                btn.findNavController().navigate(action)
            }
        }
    }
}