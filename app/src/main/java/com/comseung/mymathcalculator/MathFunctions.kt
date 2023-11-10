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

    fun euclidGcd(a: Long, b: Long): Pair<Long, Long> {
        if(b == 0L) return Pair(1L, 0L)
        val(x, y)  = euclidGcd(b, a%b)

        val d = a/b

        return Pair(y, x-d*y)
    }

    fun diophantus(a: Long, b: Long, c: Long): Pair<Long, Long>? {
        val g = gcd(a, b)
        if(g == 0L || c%g != 0L) return null

        val( x, y) = euclidGcd(a, b)
        return Pair(x*c/g, y*c/g)
    }
}