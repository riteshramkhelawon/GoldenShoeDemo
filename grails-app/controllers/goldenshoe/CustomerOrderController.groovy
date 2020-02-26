package goldenshoe

import grails.converters.JSON

class CustomerOrderController {

    def trackOrder(){
        def orderNumber = params.orderNumber
        println("number: "+orderNumber)
        CustomerOrder receivedOrder = CustomerOrder.findByOrderNumber(orderNumber)
        Boolean valid = false
        def orderStatus = null

        if (receivedOrder){
            valid = true
            orderStatus = receivedOrder.status
            println("status: "+ orderStatus)
        }

        render ([valid: valid, status: orderStatus] as JSON)

    }
}
