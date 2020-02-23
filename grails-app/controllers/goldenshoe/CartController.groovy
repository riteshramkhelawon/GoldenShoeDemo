package goldenshoe


class CartController {

    def checkout(){
        def cart = session.CART

        render(view: "checkout", model: [cart: cart])
    }

    def addToCart(){
        println("item name: " + params.item)
        def cart = session.CART
        def item = params.item != null ? Product.findByProductName(params.item) : null

        if (item != null && !cart.contains(item)){
            cart.add(item)
        }

        println("cart: " + cart)
        println("cart size: " + cart.size())

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
