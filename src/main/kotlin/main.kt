fun main(){
    val person:Person = Person("Ella","19-10-1999","58746987412365","Arapiraca")

    println(person.isOlderThan18th)

    println("Is cpf ok? ${ isCpfValid("70155406493") }")
}