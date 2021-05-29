import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// definindo open pq por padrao as classes em Kotlin sao final, entao para que
// possa haver herancas, deve-se colcoar o open
abstract class Person (var name:String, var birthDate: String, val cpf: String, val address: String){
    val isOlderThan18th: Boolean
        get(){
            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            val birth = LocalDate.parse(birthDate,formatter)

            val currentDate = LocalDateTime.now()

            val yearsPast = currentDate.year-birth.year

            return yearsPast>=18

        }




}