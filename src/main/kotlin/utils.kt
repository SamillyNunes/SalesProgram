fun isCpfValid(cpf:String):Boolean {
    if(cpf.length==11){
        val cpfCaractersList = arrayListOf<String>()
        for(caracter in cpf){ // convertendo a string em lista de caracteres
            cpfCaractersList.add(caracter.toString())
        }

        // verificando se nao ha letras maiusculas no cpf
        for(letter in 'A'..'Z'){
            if((letter in cpfCaractersList)){
                return false
            }
        }
        // verificando se nao ha letras minusculas no cpf
        for(letter in 'a'..'z'){
            if((letter in cpfCaractersList)){
                return false
            }
        }

        // validacao do primeiro digito
        var soma:Int = 0
        for(n in 0..8){ // lembrando que o intervalo eh fechado em ambos
            soma+= cpfCaractersList[n].toInt() * (10-n)
        }
        var restOfDivision = (soma*10)%11
        if(restOfDivision==10){
            restOfDivision=0
        }

        if(restOfDivision!=cpfCaractersList[9].toInt()){
            return false
        }

        // validacao do segundo digito
        var soma2:Int = 0
        for(n in 0..9){
            soma2+= cpfCaractersList[n].toInt() * (11-n)
        }
        var restOfDivision2 = (soma2*10)%11
        if(restOfDivision2==10){
            restOfDivision2=0
        }

        if(restOfDivision2!=cpfCaractersList[10].toInt()){
            return false
        }

        return true

    } else {
        return false
    }
}