package hr.osc.ada.bmicalculator.common

class ErrorCheck {
    companion object {
        fun isValidWeight(target: Double): Boolean {
            return if (target == 0.0 || target > 350.0 || target < 40.0) {
                false
            }else
                return true
        }

        fun isValidHeight(target: Double): Boolean{
            return !(target > 2.5 || target < 1.2 || target == 0.0)
        }
    }


}