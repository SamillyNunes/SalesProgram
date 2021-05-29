fun main(){
    val customer = Customer("Ella","19-10-1999","58746987412365","Arapiraca")
    val worker = Seller("Joao","20-05-2000", "52998224725", "Maceió", 1500.6)
    println(customer.isOlderThan18th)

    println("Is cpf ok? ${ isCpfValid("52998224725") }")
    println("Sálario do ${worker.name}: R\$ ${worker.salary}")

    val p1 = Product("Leite Condensado",5.60,"1542ABW","Alimento","Moça")
    val p2 = Product("Creme de Leite",3.35,"1442ABW","Alimento","Camponesa")
    val p3 = Product("Feijão Carioca",6.70,"458PLO","Alimento","Carioquinha",3)

    val products = arrayListOf<Product>(p1,p2,p3)

    val sale1 = Sale(1,worker,customer, products,PaymentType.CASH)

    print("Sale: ${sale1.paymentType}")
}