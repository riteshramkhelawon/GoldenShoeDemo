package goldenshoe

import grails.converters.JSON
import org.apache.commons.lang.RandomStringUtils

class CustomerOrderController {

    def completeOrder(){
        def cart = session.CART
        def customerName = params.name
        def mobile = params.mobile
        def customerAddress = params.addressLine1 +", " + params.postcode
        Double totalPrice = params.double('discountedTotalHidden')
        Boolean wasVoucherApplied = params.boolean('wasVoucherApplied')

        //generate a random alphanumeric string
        def orderNumber = RandomStringUtils.randomAlphanumeric(6)

        //create a new CustomerOrder object and save to the database
        CustomerOrder newOrder = new CustomerOrder(
                orderNumber: orderNumber,
                products: cart,
                customerName: customerName,
                customerAddress: customerAddress,
                customerTelephone: mobile,
                totalPrice: totalPrice,
                status: "Dispatching"
        ).save(flush: true)


        //update the stock of each product currently in the cart that the user has just ordered
        for(CartProduct cartProduct in cart){
            Product product = Product.findByProductName(cartProduct.product.productName)
            product.stock = product.stock - cartProduct.quantity
            product.save(flush: true)
        }


        render(view: "confirmation", model: [customerName: customerName, mobile: mobile, customerAddress: customerAddress,
                                             order: newOrder, totalPrice: totalPrice, wasVoucherApplied: wasVoucherApplied])
    }

    def trackOrder(){
        def orderNumber = params.orderNumber
        CustomerOrder receivedOrder = CustomerOrder.findByOrderNumber(orderNumber)
        Boolean valid = false
        def orderStatus = null

        //if the orderNumber entered by the user exists in the database, get the status of their order
        if (receivedOrder){
            valid = true
            orderStatus = receivedOrder.status
        }

        render ([valid: valid, status: orderStatus] as JSON)

    }
}
