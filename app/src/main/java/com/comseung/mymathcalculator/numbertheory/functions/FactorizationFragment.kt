package com.comseung.mymathcalculator.numbertheory.functions

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.comseung.mymathcalculator.BaseFragment
import com.comseung.mymathcalculator.MathFunctions
import com.comseung.mymathcalculator.R
import com.comseung.mymathcalculator.databinding.OneValueCalculatorLayoutBinding

class FactorizationFragment: BaseFragment<OneValueCalculatorLayoutBinding>(OneValueCalculatorLayoutBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCalculate.setOnClickListener {
            val a = binding.value1.text.toString().toLongOrNull()

            if(a == null ) {
                Toast.makeText(context, context?.getString(R.string.use_integer_desc), Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val result = MathFunctions.factorization(a)
            val descBuilder = StringBuilder()
            result.forEach { entry ->
                entry.key
                descBuilder.append("${entry.key}^${entry.value}\n")
            }
            binding.resultDescription.text = descBuilder.toString()
        }

    }
}