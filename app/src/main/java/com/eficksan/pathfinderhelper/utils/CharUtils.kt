package com.eficksan.pathfinderhelper.utils

import java.lang.Math.*

/**
 * Created by Aleksei on 11.01.2018.
 */
class CharUtils {

    companion object {
        fun calculateModifier(charValue: Int): Int {
            // TODO: should return -2 in case -2.8 and 2 in case 2 2.8
            val sign = signum(charValue - 10.0)
            return (ceil(abs((charValue - 10.0) / 2)) * sign).toInt()
        }
    }
}