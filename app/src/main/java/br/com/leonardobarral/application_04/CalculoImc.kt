package br.com.leonardobarral.application_04

import kotlin.math.pow

fun calcularImc(peso:Double,altura:Double): Double {
    var imc = peso /(altura /100).pow(2)
    return imc
}

fun obterStatusIMC(imc:Double):String{
    return if(imc < 18.5){
        "Abaixo do peso"
    }else if (imc < 25){
        "Peso Ideal"
    }else if (imc < 30){
        "Acima do peso"
    }else if (imc < 35){
        "Obseidade Grau I"
    }else if (imc < 40){
        "Obseidade Grau II"
    }else {
        "Obseidade Grau III"
    }
}

fun obterCorStausIMC(status:String): Long {
    var color = 0xFFFFFFFF
    when(status){
        "Abaixo do peso" -> color = 0xFF329f6b
        "Peso Ideal" -> color = 0xFF329f6b
        "Acima do peso" -> color = 0xFFF0C903
        "Obseidade Grau I" -> color = 0xFFFF5722
        "Obseidade Grau II" -> color = 0xFFFF0000
        "Obseidade Grau III" -> color = 0xFFFF0000
    }
    return color
}