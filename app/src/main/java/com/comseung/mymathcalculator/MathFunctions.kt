package com.comseung.mymathcalculator

import kotlin.math.abs

object MathFunctions {

    fun gcd(a: Long, b: Long): Long {
        if(b == 0L) return a
        return gcd(b, a%b)
    }

    fun lcm(a: Long, b: Long): Long {
        val g = gcd(a, b)
        return abs(a/g*b)
    }
}