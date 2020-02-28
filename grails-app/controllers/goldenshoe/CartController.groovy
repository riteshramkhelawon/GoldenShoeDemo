package goldenshoe

import org.apache.commons.lang.RandomStringUtils
import grails.converters.JSON

class CartController {

    CartProductService cartProductService

    def checkout(){
        def cart = session.CART
        def totalPrice = 0

        for(CartProduct cartProduct in cart){
            totalPrice = totalPrice + cartProduct.product.price*cartProduct.quantity
        }

        render(view: "checkout", model: [cart: cart, totalPrice: totalPrice])
    }

    def addToCart(){
        def cart = session.CART
        def productName = params.item
        def size = params.int('size')
        def quantity = params.int('quantity')

        Product productToAdd = productName != null ? Product.findByProductName(productName) : null

        println("params: "+productToAdd+", "+size+", "+quantity)

        if(productName != null && size != null && quantity != null){
            def addToCart = false

            def newCartProduct = new CartProduct(
                    product: productToAdd,
                    size: size,
                    quantity: quantity
            )

            println("CP: "+newCartProduct)

            if (!cart.isEmpty()){
                for(CartProduct cartProduct in cart){
                    if (cartProduct.product.productName == newCartProduct.product.productName){
                        if (cartProduct.size == newCartProduct.size){
                            cartProduct.quantity = cartProduct.quantity + newCartProduct.quantity
                            println("product:size(exists): FALSE")
                            addToCart = false
                            break
                        } else{
                            println("product(exists): TRUE")
                            addToCart = true

                        }
                    } else {
                        println("doesnt exist: TRUE")
                        addToCart = true
                    }
                }
            } else {
                println("1st prod: TRUE")
                addToCart = true
            }


            if (addToCart){
                cart.add(newCartProduct)
                newCartProduct.save(flush: true)
                println(productToAdd.productName + " added to cart")
            } else {
                println("do not add to cart------------------------")
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
        Double totalPrice = params.double('discountedTotalHidden')
        Boolean wasVoucherApplied = params.boolean('wasVoucherApplied')

        def orderNumber = RandomStringUtils.randomAlphanumeric(6)

        println("orderNo: "+orderNumber)


//        for(CartProduct cartProduct in cart){
//            println("old stock: "+cartProduct.product.stock)
//            cartProduct.product.stock = cartProduct.getProduct().getStock() - cartProduct.getQuantity()
//            println("new stock: "+cartProduct.product.stock)
//
//        }

        println("params price: "+totalPrice)
        println("params wasVoucherApplied: "+wasVoucherApplied)

        CustomerOrder newOrder = new CustomerOrder(
                orderNumber: orderNumber,
                products: cart,
                customerName: customerName,
                customerAddress: customerAddress,
                customerTelephone: mobile,
                totalPrice: totalPrice,
                status: "Dispatching"
        ).save(flush: true)


        for(CartProduct cartProduct in cart){
            Product product = Product.findByProductName(cartProduct.product.productName)
            println("old stock: "+cartProduct.product.stock)
            product.stock = product.stock - cartProduct.quantity
            product.save(flush: true)
            println("new stock: "+product.stock)
        }


        render(view: "confirmation", model: [customerName: customerName, mobile: mobile, customerAddress: customerAddress,
                                             order: newOrder, totalPrice: totalPrice, wasVoucherApplied: wasVoucherApplied])
    }

    def clearCart(){
        def cart = session.CART
        cart.clear()

        redirect action: 'index', controller: 'home', namespace: null
    }

    def calculateDiscountedTotal(){
        def voucherCode = params.voucherCode
        def totalPrice = params.double('totalPrice')
        def valid
        def today = new Date()

        println("voucher code: " + voucherCode)
        println("totalPrice: " + totalPrice)

        Voucher voucher = Voucher.findByVoucherCode(voucherCode)

        if (voucher && today < voucher.expiry){
            valid = true
            double discount = totalPrice*voucher.discount
            totalPrice = totalPrice - discount
            println("new Price: " + totalPrice)
        } else {
            valid = false
        }

        render ([valid: valid, discountedTotal: totalPrice] as JSON)


    }
}
