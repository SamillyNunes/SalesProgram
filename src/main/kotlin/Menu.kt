class Menu {
    val listProducts = arrayListOf<Product>()
    val listCustomers = arrayListOf<Customer>()
    val listSellers = arrayListOf<Seller>()
    val listSales = arrayListOf<Sale>()

    var saleCode = 0

    fun initialize(){
        var intOption:Int = 0

        while (intOption!=10){
            println("--------------------------------------------------------")
            println("--------------------- Shopping App ---------------------")
            println("--------------------------------------------------------")
            println("Escolha a sua opção:")
            println("1 - Cadastrar produto")
            println("2 - Cadastrar vendedor")
            println("3 - Cadastrar cliente")
            println("4 - Iniciar venda")
            println("5 - Listar produtos")
            println("7 - Listar vendedores")
            println("8 - Listar clientes")
            println("9 - Listar vendas")
            println("10 - - Sair")
            var option = readLine()
            // poderia ser tb: var intOption = option?.toInt() ?: 10
            intOption = if(option!=null && option!="") option.toInt() else 10

            when(intOption){
                1 -> createProduct()
                2 -> createSeller()
                3 -> createCustomer()
                4 -> initializeSale()
                5 -> listProducts()
                6 -> listSellers()
                7 -> listCustomers()
                8 -> listSales()
                else -> println("Até a próxima!")
            }
        }

    }

    fun createProduct(){
        println("\n--------------------- Cadastro de Produtos ---------------------")
        println("Descrição do produto:")
        val description = readLine() ?: ""
        println("Preço do produto:")
        val priceString = readLine()
        var price:Double = 0.0
        while (price!=0.0){
            try{
                if(priceString!=null && priceString!=""){
                    price = priceString.toDouble()
                }
            } catch ( e:Exception){
                println("priceInvalid")
            }
        }
        println("Código do produto:")
        val code = readLine() ?: ""
        println("Categoria do produto:")
        val category = readLine() ?: ""
        println("Marca do produto:")
        val brand = readLine() ?: ""
        println("Quantidade do produto:")
        val quantityString = readLine()
        var quantity:Int = 1
        if(quantityString!=null && quantityString!=""){
            quantity = quantityString.toInt()
        }

        val p = Product(description,price,code,category,brand,quantity)
        this.listProducts.add(p)

        println("Produto cadastrado com sucesso!\n")
    }

    fun createCustomer(){
        println("\n--------------------- Cadastro de Clientes ---------------------")
        println("Nome do cliente:")
        var name = readLine();
        while(name==null || name==""){
            println("Nome inválido. Digite novamente:")
            name = readLine();
        }
        println("Data de nascimento:")
        var date = readLine();
        while(date==null || date==""){
            println("Data inválida. Digite novamente:")
            date = readLine();
        }
        println("CPF:")
        var cpf = readLine();
        if(cpf!=null || cpf!="" || !isCpfValid(cpf)){
            while (!isCpfValid(cpf!!)){
                println("CPF inválido. Digite novamente:")
                cpf = readLine();
            }
        }
        println("Endereço:")
        var address = readLine();
        while(address==null || address==""){
            println("Endereço inválido. Digite novamente:")
            address = readLine();
        }

        val customer = Customer(name,date,cpf,address)

    }

    fun createSeller(){
        println("\n--------------------- Cadastro de Vendedores ---------------------")
        println("Nome do vendedor:")
        var name = readLine();
        while(name==null || name==""){
            println("Nome inválido. Digite novamente:")
            name = readLine();
        }
        println("Data de nascimento:")
        var date = readLine();
        while(date==null || date==""){
            println("Data inválida. Digite novamente:")
            date = readLine();
        }
        println("CPF:")
        var cpf = readLine();
        if(cpf!=null || cpf!="" || !isCpfValid(cpf)){
            while (!isCpfValid(cpf!!)){
                println("CPF inválido. Digite novamente:")
                cpf = readLine();
            }
        }
        println("Endereço:")
        var address = readLine();
        while(address==null || address==""){
            println("Endereço inválido. Digite novamente:")
            address = readLine();
        }
        println("Salário:")
        var salary = readLine();
        while(salary==null || salary==""){
            println("Salário inválido. Digite novamente:")
            salary = readLine();
        }

        val seller = Seller(name,date,cpf,address, salary.toDouble())

    }

    fun initializeSale(){
        println("\n--------------------- Venda iniciada ---------------------")
        var option:String ="1"
        val ps = arrayListOf<Product>()
        // for para produtos:
        do {
            println("Digite o código do produto:")
            var productCode = readLine();
            while(productCode==null || productCode==""){
                println("Código inválido. Digite novamente:")
                productCode = readLine();
            }
            var p = searchProduct(productCode)
            while(p==null){
                while(productCode==null || productCode==""){
                    println("Código inválido. Digite novamente:")
                    productCode = readLine();
                }
                p = searchProduct(productCode)
            }
            println("Digite a quantidade do produto:")
            val qtd = readLine() ?: 1;
            p.quantity = qtd as Int

            ps.add(p)

            println("Se deseja continuar a inserir produtos, digite 1, caso contrário digite 0:")
            option = readLine() ?: "0"
        }while (option!="0")

        // vendedor
        println("Digite o CPF do vendedor responsável:")
        var sellerCpf = readLine();
        while(sellerCpf==null || sellerCpf==""){
            println("CPF inválido. Digite novamente:")
            sellerCpf = readLine();
        }
        var s = searchSeller(sellerCpf)
        while(s==null){
            while(sellerCpf==null || sellerCpf==""){
                println("CPF inválido. Digite novamente:")
                sellerCpf = readLine();
            }
            s = searchSeller(sellerCpf)
        }

        // cliente
        println("Digite o CPF do cliente:")
        var customerCpf = readLine();
        while(customerCpf==null || customerCpf==""){
            println("CPF inválido. Digite novamente:")
            customerCpf = readLine();
        }
        var c = searchCustomer(customerCpf)
        while(c==null){
            while(customerCpf==null || customerCpf==""){
                println("CPF inválido. Digite novamente:")
                customerCpf = readLine();
            }
            c = searchCustomer(customerCpf)
        }

        println("Digite a forma de pagamento:")
        var payment = readLine()
        while(payment==null || payment==""){
            println("CPF inválido. Digite novamente:")
            payment = readLine();
        }

        val paymentType: PaymentType
        when(payment.toLowerCase()){
            "cash"-> paymentType=PaymentType.CASH
            "debit"-> paymentType=PaymentType.DEBIT
            "credit"-> paymentType=PaymentType.CREDIT
            "pix"-> paymentType=PaymentType.PIX
            else -> paymentType=PaymentType.CASH
        }

        val sale = Sale(saleCode,s,c,ps,paymentType)
        this.saleCode++
        this.listSales.add(sale)
    }

    fun searchProduct(code:String): Product? {
        for(product in this.listProducts){
            if(product.code.equals(code)){
                return product
            }
        }
        return null
    }

    fun searchCustomer(cpf:String): Customer? {
        for(customer in this.listCustomers){
            if(customer.cpf.equals(cpf)){
                return customer
            }
        }
        return null
    }
    fun searchSeller(cpf:String): Seller? {
        for(seller in this.listSellers){
            if(seller.cpf.equals(cpf)){
                return seller
            }
        }
        return null
    }

    fun listProducts(){
        println("\n--------------------- Listagem de Produtos ---------------------")
        for(product in this.listProducts){
            println(product)
        }
        println("\n--------------------- Fim da Listagem de Produtos ---------------------")
    }

    fun listSellers(){
        println("\n--------------------- Listagem de Vendedores ---------------------")
        for(seller in this.listSellers){
            println(seller)
        }
        println("\n--------------------- Fim da Listagem de Vendedores ---------------------")
    }

    fun listCustomers(){
        println("\n--------------------- Listagem de Clientes ---------------------")
        for(customer in this.listCustomers){
            println(customer)
        }
        println("\n--------------------- Fim da Listagem de Clientes ---------------------")
    }

    fun listSales(){
        println("\n--------------------- Listagem de Vendas ---------------------")
        for(sale in this.listSales){
            println(sale)
        }
        println("\n--------------------- Fim da Listagem de Vendas ---------------------")
    }
}