package com.comseung.mymathcalculator

import android.util.Range
import kotlin.math.abs
import kotlin.math.sqrt

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

    fun isPrime(n: Long): Boolean {
        if(n <= 1) return false
        else if(n == 2L) return true

        val sn = sqrt(n.toDouble()).toLong()
        for(i in 2..sn) {
            if(n%i == 0L) return false
        }
        return true
    }

    fun getPrimes(n: Long): List<Long> {
        if(n <= 1) return emptyList()

        val isPrimeCheckTable = BooleanArray(n.toInt()+1) { true }
        isPrimeCheckTable[0] = false
        isPrimeCheckTable[1] = false

        var i = 2
        while(i*i <=n) {
            if(isPrimeCheckTable[i]) {
                var j = i*i
                while(j <= n) {
                    isPrimeCheckTable[j] = false
                    j += i
                }
            }
            ++i
        }

        return isPrimeCheckTable.mapIndexed { index, b -> if(b) index.toLong() else -1L }.filter { it != -1L }
    }

    fun isSquareNumber(n: Long): Boolean {
        if(n<0) return false
        else if(n<=1) return true

        val sn = sqrt(n.toDouble()).toLong()
        return sn*sn == n
    }

    fun factorization(n: Long): Map<Long, Long> {
        if(n<=1) return emptyMap()

        val factorTable = LongArray(n.toInt()+1) { it -> it.toLong() }
        var i = 2L
        while(i*i <=n) {
            if(factorTable[i.toInt()] == i) {
                var j = i*i
                while(j <= n) {
                    factorTable[j.toInt()] = i
                    j += i
                }
            }
            ++i
        }

        val ret = mutableMapOf<Long, Long>()
        var x = n
        while(x > 1) {
            val factor = factorTable[x.toInt()]
            x /= factor
            ret[factor] = ret[factor]?.plus(1L) ?: 1
        }
        return ret
    }
}