package hr.osc.ada.bmicalculator.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import hr.osc.ada.bmicalculator.R
import hr.osc.ada.bmicalculator.common.BodyMassIndexType
import hr.osc.ada.bmicalculator.common.ErrorCheck
import hr.osc.ada.bmicalculator.model.Person
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    lateinit var person: Person

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        calculateButton.setOnClickListener {isFormValid()}
    }

    private fun isFormValid() {
        var height: Double = heightEditText.text.toString().toDouble()
        var weight: Double = weightEditText.text.toString().toDouble()

        if(ErrorCheck.isValidHeight(height)&& ErrorCheck.isValidWeight(weight)){
            person = Person(weight, height)
            selectBMI(person.calculateBMI())
        }else{
            Toast.makeText(this, getString(R.string.invalid_entry), Toast.LENGTH_SHORT).show()
        }
    }

    private fun selectBMI(calc: Double){
        when(calc){
            in 0.0..18.5 -> setData(BodyMassIndexType.UNDERWEIGHT)
            in 18.5..24.9 -> setData(BodyMassIndexType.NORMAL)
            in 25.0..29.9 -> setData(BodyMassIndexType.OVERWEIGHT)
            in 30.0..60.0-> setData(BodyMassIndexType.OBESE)
        }
    }

    private fun setData(info: BodyMassIndexType) {
        image.setImageResource(info.image)
        calculatedBMIDescription.text = this.getString(info.description)
        calculatedBMIName.text = this.getString(info.type)
        calculatedBMI.text = "%.2f".format(person.calculateBMI())
    }
}
