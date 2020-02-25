package goldenshoe

import org.apache.commons.lang.RandomStringUtils

class CartController {

    CartProductService cartProductService

    def checkout(){
        def cart = session.CART

        render(view: "checkout", model: [cart: cart])
    }

    def addToCart(){
        def cart = session.CART
        def productName = params.item
        def size = params.int('size')
        def quantity = params.int('quantity')

        Product productToAdd = productName != null ? Product.findByProductName(productName) : null

        println("params: "+productToAdd+", "+size+", "+quantity)

        if(productName != null && size != null && quantity != null){
            def alreadyExists = false

            def newCartProduct = new CartProduct(
                    product: productToAdd,
                    size: size,
                    quantity: quantity
            ).save(flush: true)

            println("CP: "+newCartProduct)

            for(CartProduct cartProduct in cart){
                if (cartProduct.product.productName == newCartProduct.product.productName){
                    alreadyExists = true
                    break
                }
            }

            if (!alreadyExists){
                cart.add(newCartProduct)
                println(productToAdd.productName + " added to cart")
            } else {
                println("item already exists in cart")
            }

            println("new cart: " + cart)
        }

        render(view: "checkout", model: [cart: cart])
    }


    def removeFromCart() {
        def cart = session.CART
        CartProduct cartProductToRemove = CartProduct.findById(params.item)

        println("item to remove: "+cartProductToRemove)

        cart.retainAll{it.id != cartProductToRemove.id}

        cartProductService.delete(cartProductToRemove.id)

        println("new cart: "+cart)

        redirect(action: "checkout")
    }

    def completeOrder(){
        def cart = session.CART
        def customerName = params.name
        def mobile = params.mobile
        def customerAddress = params.addressLine1 +", " + params.postcode

        def orderNumber = RandomStringUtils.randomAlphanumeric(6)

        println("orderNo: "+orderNumber)

        CustomerOrder newOrder = new CustomerOrder(
                orderNumber: orderNumber,
                products: cart,
                customerName: customerName,
                customerAddress: customerAddress,
                customerTelephone: mobile,
                status: "Dispatching"
        ).save(flush: true)

        render(view: "confirmation", model: [customerName: customerName, mobile: mobile, customerAddress: customerAddress,
                                             order: newOrder])
    }

    def clearCart(){
        def cart = session.CART
        cart.clear()

        redirect action: 'index', controller: 'home', namespace: null
    }











}
