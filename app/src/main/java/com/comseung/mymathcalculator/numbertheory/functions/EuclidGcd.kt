package com.comseung.mymathcalculator.numbertheory.functions

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.comseung.mymathcalculator.BaseFragment
import com.comseung.mymathcalculator.MathFunctions
import com.comseung.mymathcalculator.R
import com.comseung.mymathcalculator.databinding.TwoValueCaculatorLayoutBinding

class EuclidGcd: BaseFragment<TwoValueCaculatorLayoutBinding>(TwoValueCaculatorLayoutBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnCalculate.setOnClickListener {
            val a = binding.value1.text.toString().toLongOrNull()
            val b = binding.value2.text.toString().toLongOrNull()

            if(a == null || b == null) {
                Toast.makeText(context, context?.getString(R.string.use_integer_desc), Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val (x, y) = MathFunctions.euclidGcd(a, b)
            val g = MathFunctions.gcd(a, b)

            val ans = "x: $x, y: $y gcd: $g"
            binding.result.text = ans
            val desc = "($x)*($a) + ($y)*($b) = $g (valid?: ${a*x + b*y == g})"
            binding.resultDescription.text = desc
        }

    }
}