package goldenshoe

import org.apache.commons.lang.RandomStringUtils
import grails.converters.JSON

class CartController {

    CartProductService cartProductService

    def checkout(){
        //retrieve the current cart from the session
        def cart = session.CART
        def totalPrice = 0

        //loop through all cartProducts in the cart and sum the prices
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

        if(productName != null && size != null && quantity != null){
            def addToCart = false

            //create new CartProduct object
            def newCartProduct = new CartProduct(
                    product: productToAdd,
                    size: size,
                    quantity: quantity
            )

            //if cart is not empty, search for the same products in the cart
            if (!cart.isEmpty()){
                for(CartProduct cartProduct in cart){
                    if (cartProduct.product.productName == newCartProduct.product.productName){
                        if (cartProduct.size == newCartProduct.size){
                            //if the product in the cart and the product to be added are the same, with the same size
                            //only update the quantity of the CartProduct in the current cart, do not re-add the CartProduct
                            cartProduct.quantity = cartProduct.quantity + newCartProduct.quantity
                            addToCart = false
                            break
                        } else{
                            //if the sizes of the products are not the same, add the new CartProduct to the cart
                            addToCart = true
                        }
                    } else {
                        //if the products are not the same, add the new CartProduct to the cart
                        addToCart = true
                    }
                }
            } else {
                //if the cart is empty, add the CartProduct to the cart
                addToCart = true
            }

            if (addToCart){
                //add the CartProduct to the current cart
                cart.add(newCartProduct)
                newCartProduct.save(flush: true)
            }
        }

        render(view: "checkout", model: [cart: cart])
    }


    def removeFromCart() {
        def cart = session.CART
        CartProduct cartProductToRemove = CartProduct.findById(params.item)

        //retain all CartProducts in the cart, apart from the CartProduct which the user wishes to remove (indicated by id)
        cart.retainAll{it.id != cartProductToRemove.id}
        cartProductService.delete(cartProductToRemove.id)

        redirect(action: "checkout")
    }

    def clearCart(){
        def cart = session.CART

        //clear all CartProducts from the current cart
        cart.clear()

        redirect action: 'index', controller: 'home', namespace: null
    }

    def calculateDiscountedTotal(){
        def voucherCode = params.voucherCode
        def totalPrice = params.double('totalPrice')
        def valid
        def today = new Date()

        //use the voucherCode entered by the user and check if the voucher exists in the database
        Voucher voucher = Voucher.findByVoucherCode(voucherCode)

        //if the voucher exists and is not expired, calculate the discounted total
        if (voucher && today < voucher.expiry){
            valid = true
            double discount = totalPrice*voucher.discount
            totalPrice = totalPrice - discount
        } else {
            valid = false
        }

        render ([valid: valid, discountedTotal: totalPrice] as JSON)

    }
}
