package com.comseung.mymathcalculator.numbertheory.functions

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Toast
import com.comseung.mymathcalculator.BaseFragment
import com.comseung.mymathcalculator.MathFunctions
import com.comseung.mymathcalculator.R
import com.comseung.mymathcalculator.databinding.ThreeValueCalculatorLayoutBinding
import kotlin.math.max
import kotlin.math.min

class DiophantusFragment: BaseFragment<ThreeValueCalculatorLayoutBinding>(ThreeValueCalculatorLayoutBinding::inflate) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.resultDescription.apply {
            movementMethod = ScrollingMovementMethod()
        }

        binding.btnCalculate.setOnClickListener {
            val a = binding.value1.text.toString().toLongOrNull()
            val b = binding.value2.text.toString().toLongOrNull()
            val c = binding.value3.text.toString().toLongOrNull()
            if(a == null || b == null || c == null) {
                Toast.makeText(context, context?.getString(R.string.use_integer_desc), Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val (x0, y0) = MathFunctions.diophantus(a, b, c) ?: run {
                val ans = context?.getString(R.string.no_solution)
                binding.result.text = ans
                return@setOnClickListener
            }


            val ans = "x0: $x0, y0: $y0"
            val g = MathFunctions.gcd(a, b)
            val descBuilder = StringBuilder("($x0)*($a) + ($y0)*($b) = $c (valid?: ${a*x0 + b*y0 == c})\n")
            descBuilder.append("generalization:\nx = $x0 + (${b/g})*t\ny = $y0 - (${a/g})*t\n")
            descBuilder.append("-------------------------------------------\n")
            val lb = min(-x0*g/b, y0*g/a)
            val ub = max(-x0*g/b, y0*g/a)

            for(t in lb..min(ub, lb+10)) {
                val x = x0 + (b/g)*t
                val y = y0 - (a/g)*t
                descBuilder.append("($x)*($a) + ($y)*($b) = $c\n")
            }
            binding.resultDescription.text = descBuilder.toString()
        }

    }
}