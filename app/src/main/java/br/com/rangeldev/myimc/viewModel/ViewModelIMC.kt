package br.com.rangeldev.myimc.viewModel

class ViewModelIMC(val height : String, val weight:String) {

    fun startCalc():String{
        var result = ""
        val weithGirl = calcIdealWeigthGils(height)
        val  weithMan = calcIdealWeigthMan(height)
        val resultIdealWeith = "Peso ideal Masculino: $weithMan.\n\nPeso ideal Feminio: $weithGirl."

                val imc =   calcIMC(weight,height )
                val imcResp = "\nIMC:" + "%.2f".format(imc) + "\n\n" + checkIMC(imc) + "\n"
                result = imcResp
        return result +"\n\n"+resultIdealWeith
    }
    // Cálculo do IMC
    private fun calcIMC(peso: String, altura: String): Double  {
        altura.replace(",",".")
        val res = peso.toDouble() / (altura.toDouble() * altura.toDouble())
        println("$res")
        return res
    }
    // Retorna string de acordo com o cálculo
    private fun checkIMC(db: Double): String{
        return when(db) {
            in 0.0 ..17.0 -> "Muito Atenção você esta abaixo do peso, procure um médico se possível."
            in 17.1..18.49 -> "Atenção Abaixo do peso."
            in 18.5..24.99 -> "Parabens Peso normal."
            in 25.0..29.99 ->  "Você esta acima do peso procure perder peso"
            in 30.0..34.99 -> "Cuidado Obesidade I procure perder peso."
            in 35.0..39.99 -> "Atenção você esta em um quadro de Obesidade II (OBESIDADE SEVERA),"+
                    " procure um médico se possível."
            else -> "Muita atenção você esta em um quadro de Obesidade III  (OBESIDADE MÓRBIDA),"+
                    " procure um médico se possível."
        }
    }

    private fun calcIdealWeigthMan(height:String):String{
        val heightNotPont = height.replace(".","")
        val heightInt:Int = heightNotPont.toInt()
        println("SEM PONTO $heightInt")
        val res = (heightInt - 100) * 0.98
        return "%.2f".format(res)
    }
    private fun calcIdealWeigthGils(height:String):String{
        val heightNotPont = height.replace(".","")
        val heightInt:Int = heightNotPont.toInt()
        println("SEM PONTO $heightInt")
        val res = (heightInt - 100) * 0.85
        return "%.2f".format(res)
    }
}


