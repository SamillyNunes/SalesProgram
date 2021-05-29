fun main(){
    val person:Person = Customer("Ella","19-10-1999","58746987412365","Arapiraca")
    val worker = Seller("Joao","20-05-2000", "52998224725", "Maceió", 1500.6)
    println(person.isOlderThan18th)

    println("Is cpf ok? ${ isCpfValid("52998224725") }")
    println("Sálario do ${worker.name}: R\$ ${worker.salary}")
}