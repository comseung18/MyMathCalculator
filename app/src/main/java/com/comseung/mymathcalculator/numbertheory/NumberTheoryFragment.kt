package com.comseung.mymathcalculator.numbertheory

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.comseung.mymathcalculator.BaseFragment
import com.comseung.mymathcalculator.R
import com.comseung.mymathcalculator.SimpleAdapter
import com.comseung.mymathcalculator.databinding.FragmentNumbertheoryMainBinding

class NumberTheoryFragment: BaseFragment<FragmentNumbertheoryMainBinding>(FragmentNumbertheoryMainBinding::inflate) {

    private val simpleAdapter: SimpleAdapter by lazy {
        SimpleAdapter(getNumberTheoryItems(context))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = simpleAdapter
        }
    }
}