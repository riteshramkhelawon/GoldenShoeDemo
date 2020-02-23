package goldenshoe


class CartController {



    def index(){
        println("item name: " + params.item)
        List<Product> cart = (List<Integer>)session.getAttribute("CART")
        def item = params.item != null ? Product.findByProductName(params.item) : null

        if (item != null && !cart.contains(item)){
            cart.add(item)
        }

        println("cart: " + cart)
        println("cart size: " + cart.size())

        render(view: "checkout", model: [cart: cart])
    }

    def addToCart(Product item) {
        cart.add(item)
    }

    def removeFromCart(Product item) {
        cart.remove(item)
    }

    def clearCart() {
        cart.clear()
    }








}
