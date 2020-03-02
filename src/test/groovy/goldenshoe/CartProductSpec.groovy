package goldenshoe

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class CartProductSpec extends Specification implements DomainUnitTest<CartProduct> {
    void "Test validation of a complete CartProduct"() {
        given: "a complete new CartProduct"

        def product = Mock(Product)
        def quantity = 5
        def size = 9


        def cartProduct = new CartProduct(product: product, quantity: quantity, size: size)

        expect:"validation passes"
        true == cartProduct.validate()
    }

    void "Test validation of an incomplete CartProduct with no product"() {
        given: "no product"

        def product = null
        def quantity = 5
        def size = 9


        def cartProduct = new CartProduct(product: product, quantity: quantity, size: size)

        expect:"validation fails"
        false == cartProduct.validate()
    }

    void "Test validation of a complete with no quantity"() {
        given: "no quantity"

        def product = Mock(Product)
        def quantity = null
        def size = 9


        def cartProduct = new CartProduct(product: product, quantity: quantity, size: size)

        expect:"validation fails"
        false == cartProduct.validate()
    }

    void "Test validation of a complete CartProduct with no size"() {
        given: "no size"

        def product = Mock(Product)
        def quantity = 5
        def size = null


        def cartProduct = new CartProduct(product: product, quantity: quantity, size: size)

        expect:"validation fails"
        false == cartProduct.validate()
    }
}
