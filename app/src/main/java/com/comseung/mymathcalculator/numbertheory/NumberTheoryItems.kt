package com.comseung.mymathcalculator.numbertheory

import android.content.Context
import com.comseung.mymathcalculator.R
import com.comseung.mymathcalculator.SimpleAdapterItem

fun getNumberTheoryItems(context: Context?): List<SimpleAdapterItem> {

    return if(context != null) {
        listOf(
            SimpleAdapterItem(
                context.getString(R.string.gcd),
                NumberTheoryFragmentDirections.actionNumberTheoryFragmentToGcdFragment()
            ),
            SimpleAdapterItem(
                context.getString(R.string.lcm),
                NumberTheoryFragmentDirections.actionNumberTheoryFragmentToLcmFragment()
            ),
            SimpleAdapterItem(
                context.getString(R.string.euclidGcd),
                NumberTheoryFragmentDirections.actionNumberTheoryFragmentToEuclidGcd()
            )
        )
    } else {
        emptyList()
    }

}