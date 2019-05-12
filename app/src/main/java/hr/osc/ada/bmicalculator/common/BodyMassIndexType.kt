package hr.osc.ada.bmicalculator.common

import hr.osc.ada.bmicalculator.R

enum class BodyMassIndexType(val image: Int, val description: Int,val type: Int) {

    UNDERWEIGHT(R.drawable.underweight, R.string.underweight, R.string.underweight_title),
    NORMAL(R.drawable.normal, R.string.normal, R.string.normal_title),
    OVERWEIGHT(R.drawable.overweight, R.string.overweight, R.string.overweight_title),
    OBESE(R.drawable.obese, R.string.obese, R.string.obese_title)
}