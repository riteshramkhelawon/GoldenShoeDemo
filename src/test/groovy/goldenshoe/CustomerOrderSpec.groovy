package goldenshoe

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CustomerOrderSpec extends Specification implements DomainUnitTest<CustomerOrder> {
    void "Test validation of a complete CustomerOrder"() {
        given: "a complete new CustomerOrder"

        def cartProduct1 = Mock(CartProduct)
        def cartProduct2 = Mock(CartProduct)

        def orderNumber = "12345"
        def products = [cartProduct1, cartProduct2]
        def customerName = "name"
        def customerAddress = "address"
        def customerTelephone = "telephone"
        def status = "status"
        def totalPrice = 100.00
        def dateCreated = new Date()

        def customerOrder = new CustomerOrder(orderNumber: orderNumber, products: products, customerName: customerName,
                                customerAddress: customerAddress, customerTelephone: customerTelephone, status: status,
                                totalPrice: totalPrice, dateCreated: dateCreated)

        expect: "validation passes"
        true == customerOrder.validate()
    }

    void "Test validation of a incomplete CustomerOrder with no order number"() {
        given: "no order number"

        def cartProduct1 = Mock(CartProduct)
        def cartProduct2 = Mock(CartProduct)

        def orderNumber = null
        def products = [cartProduct1, cartProduct2]
        def customerName = "name"
        def customerAddress = "address"
        def customerTelephone = "telephone"
        def status = "status"
        def totalPrice = 100.00
        def dateCreated = new Date()

        def customerOrder = new CustomerOrder(orderNumber: orderNumber, products: products, customerName: customerName,
                customerAddress: customerAddress, customerTelephone: customerTelephone, status: status,
                totalPrice: totalPrice, dateCreated: dateCreated)

        expect: "validation fails"
        false == customerOrder.validate()
    }

    void "Test validation of a incomplete CustomerOrder with no products"() {
        given: "no products"

        def orderNumber = "12345"
        def products = null
        def customerName = "name"
        def customerAddress = "address"
        def customerTelephone = "telephone"
        def status = "status"
        def totalPrice = 100.00
        def dateCreated = new Date()

        def customerOrder = new CustomerOrder(orderNumber: orderNumber, products: products, customerName: customerName,
                customerAddress: customerAddress, customerTelephone: customerTelephone, status: status,
                totalPrice: totalPrice, dateCreated: dateCreated)

        expect: "validation fails"
        false == customerOrder.validate()
    }

    void "Test validation of a incomplete CustomerOrder with no customer name"() {
        given: "no customer name"

        def cartProduct1 = Mock(CartProduct)
        def cartProduct2 = Mock(CartProduct)

        def orderNumber = "12345"
        def products = [cartProduct1, cartProduct2]
        def customerName = null
        def customerAddress = "address"
        def customerTelephone = "telephone"
        def status = "status"
        def totalPrice = 100.00
        def dateCreated = new Date()

        def customerOrder = new CustomerOrder(orderNumber: orderNumber, products: products, customerName: customerName,
                customerAddress: customerAddress, customerTelephone: customerTelephone, status: status,
                totalPrice: totalPrice, dateCreated: dateCreated)

        expect: "validation fails"
        false == customerOrder.validate()
    }

    void "Test validation of a incomplete CustomerOrder with no address"() {
        given: "no address"

        def cartProduct1 = Mock(CartProduct)
        def cartProduct2 = Mock(CartProduct)

        def orderNumber = "12345"
        def products = [cartProduct1, cartProduct2]
        def customerName = "name"
        def customerAddress = null
        def customerTelephone = "telephone"
        def status = "status"
        def totalPrice = 100.00
        def dateCreated = new Date()

        def customerOrder = new CustomerOrder(orderNumber: orderNumber, products: products, customerName: customerName,
                customerAddress: customerAddress, customerTelephone: customerTelephone, status: status,
                totalPrice: totalPrice, dateCreated: dateCreated)

        expect: "validation fails"
        false == customerOrder.validate()
    }

    void "Test validation of a incomplete CustomerOrder with no telephone"() {
        given: "no telephone"

        def cartProduct1 = Mock(CartProduct)
        def cartProduct2 = Mock(CartProduct)

        def orderNumber = "12345"
        def products = [cartProduct1, cartProduct2]
        def customerName = "name"
        def customerAddress = "address"
        def customerTelephone = null
        def status = "status"
        def totalPrice = 100.00
        def dateCreated = new Date()

        def customerOrder = new CustomerOrder(orderNumber: orderNumber, products: products, customerName: customerName,
                customerAddress: customerAddress, customerTelephone: customerTelephone, status: status,
                totalPrice: totalPrice, dateCreated: dateCreated)

        expect: "validation fails"
        false == customerOrder.validate()
    }

    void "Test validation of a incomplete CustomerOrder with no status"() {
        given: "no status"

        def cartProduct1 = Mock(CartProduct)
        def cartProduct2 = Mock(CartProduct)

        def orderNumber = "12345"
        def products = [cartProduct1, cartProduct2]
        def customerName = "name"
        def customerAddress = "address"
        def customerTelephone = "telephone"
        def status = null
        def totalPrice = 100.00
        def dateCreated = new Date()

        def customerOrder = new CustomerOrder(orderNumber: orderNumber, products: products, customerName: customerName,
                customerAddress: customerAddress, customerTelephone: customerTelephone, status: status,
                totalPrice: totalPrice, dateCreated: dateCreated)

        expect: "validation fails"
        false == customerOrder.validate()
    }

    void "Test validation of a incomplete CustomerOrder with no total price"() {
        given: "no total price"

        def cartProduct1 = Mock(CartProduct)
        def cartProduct2 = Mock(CartProduct)

        def orderNumber = "12345"
        def products = [cartProduct1, cartProduct2]
        def customerName = "name"
        def customerAddress = "address"
        def customerTelephone = "telephone"
        def status = "status"
        def totalPrice = null
        def dateCreated = new Date()

        def customerOrder = new CustomerOrder(orderNumber: orderNumber, products: products, customerName: customerName,
                customerAddress: customerAddress, customerTelephone: customerTelephone, status: status,
                totalPrice: totalPrice, dateCreated: dateCreated)

        expect: "validation fails"
        false == customerOrder.validate()
    }
}