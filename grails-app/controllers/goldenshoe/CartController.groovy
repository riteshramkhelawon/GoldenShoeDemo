package goldenshoe


class CartController {

    def checkout(){
        def cart = session.CART

        render(view: "checkout", model: [cart: cart])
    }

    def addToCart(){
//        println("item name: " + params.item)
        def cart = session.CART
        println(cart)

        def itemToAdd = params.item != null ? Product.findByProductName(params.item) : null
        println("params: "+itemToAdd)

        if (itemToAdd != null){
            def alreadyExists = false

            for(Product product in cart){
                if(product.productName == itemToAdd.productName){
                    alreadyExists = true
                    break
                }
            }

            if (!alreadyExists){
                cart.add(itemToAdd)
            } else {
                println("already exists")
            }
        }
        println("new cart: " + cart)

        render(view: "checkout", model: [cart: cart])
    }


    def removeFromCart() {
        def cart = session.CART
        println("cart: " +cart)

        def itemToRemove = params.item
        println("item to remove: "+itemToRemove)

        cart.retainAll{it.productName != itemToRemove}

        println("new cart: "+cart)

        redirect(action: "checkout")
    }

    def clearCart() {
        cart.clear()
    }








}
