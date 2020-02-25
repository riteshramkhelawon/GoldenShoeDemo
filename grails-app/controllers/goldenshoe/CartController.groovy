package goldenshoe

import org.codehaus.groovy.runtime.InvokerHelper
import org.hibernate.criterion.Order


class CartController {

    def checkout(){
        def cart = session.CART

        render(view: "checkout", model: [cart: cart])
    }

    def addToCart(){
//        println("item name: " + params.item)
        def cart = session.CART
        println(cart)
        println("params: "+params.item+", " + params.chosenSize)

        Product itemToAdd = params.item != null ? Product.findByProductName(params.item) : null
        Product itemCopy = new Product()
        InvokerHelper.setProperties(itemCopy, itemToAdd.properties)

        if (itemToAdd != null){
            def alreadyExists = false

            for(Product product in cart){
                if(product.productName == itemToAdd.productName){
                    alreadyExists = true
                    break
                }
            }

            if (!alreadyExists){
                itemCopy.availableSizes = params.chosenSize.toInteger()
                cart.add(itemCopy)
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

    def completeOrder(){
        def customerName = params.name
        def mobile = params.mobile
        def addressLine1 = params.addressLine1
        def postcode = params.postcode
        def cardNo = params.cardNo

        def quantitiesParams = params.findAll{it.key.startsWith("productQuantity")}

        println("quants: "+quantitiesParams)

        def cart = session.CART
        def confirmationCart = cart.clone()
        def orderNo = new Random().nextInt(9)

        println("conf cart: "+confirmationCart)
        Map<String, String> sizes = new HashMap<String, String>()



        for(Product product in confirmationCart){
            sizes.put(product.productName, product.availableSizes.toString())
        }

        def newOrder = new OrdersMade(
                orderNumber: orderNo,
                customer: customerName,
                productSize: sizes,
                productQuantity: quantitiesParams
        ).save(flush: true)

        println("saved " + newOrder)


        render(view: "confirmation", model: [customerName: customerName, mobile: mobile, addressLine1: addressLine1,
                                            postcode: postcode, cardNo: cardNo, cart: confirmationCart, order: newOrder])


    }

    def clearCart(){
        def cart = session.CART
        cart.clear()

        redirect action: 'index', controller: 'home', namespace: null
    }











}
