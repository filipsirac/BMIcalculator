package hr.osc.ada.bmicalculator.model

import kotlin.math.pow

class Person(
    var mass: Double,
    var height: Double
){

    fun calculateBMI():Double{
        return (mass/(height.pow(2)))
    }

}