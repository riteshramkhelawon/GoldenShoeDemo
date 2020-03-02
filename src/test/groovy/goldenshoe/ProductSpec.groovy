package goldenshoe

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ProductSpec extends Specification implements DomainUnitTest<Product> {
    void "Test validation of a complete product"() {
        given: "a complete new product"

        def productName = "product"
        def price = 5.99
        def mainImgUrl = "imageurl"
        def secondImgUrl = "imageurl"
        def thirdImgUrl = "imageurl"
        def videoUrl = "videourl"
        def shortDescription = "shortdescription"
        def descriptionPoints = ["point1", "point2", "point3"]
        def stock = 100
        def colour = "colour"
        def availableSizes = [1,2,3]
        def type = "type"

        def product = new Product(productName: productName, price: price, mainImgUrl: mainImgUrl, secondImgUrl: secondImgUrl,
                thirdImgUrl: thirdImgUrl, videoUrl: videoUrl, shortDescription: shortDescription,
                descriptionPoints: descriptionPoints, stock: stock, colour: colour, availableSizes: availableSizes,
                type: type)

        expect:"validation passes"
        true == product.validate()
    }

    void "Test validation of a incomplete product with no name"() {
        given: "no product name"

        def productName = null
        def price = 5.99
        def mainImgUrl = "imageurl"
        def secondImgUrl = "imageurl"
        def thirdImgUrl = "imageurl"
        def videoUrl = "videourl"
        def shortDescription = "shortdescription"
        def descriptionPoints = ["point1", "point2", "point3"]
        def stock = 100
        def colour = "colour"
        def availableSizes = [1,2,3]
        def type = "type"

        def product = new Product(productName: productName, price: price, mainImgUrl: mainImgUrl, secondImgUrl: secondImgUrl,
                thirdImgUrl: thirdImgUrl, videoUrl: videoUrl, shortDescription: shortDescription,
                descriptionPoints: descriptionPoints, stock: stock, colour: colour, availableSizes: availableSizes,
                type: type)

        expect:"validation fails"
        false == product.validate()
    }

    void "Test validation of a incomplete product with no price"() {
        given: "no product price"

        def productName = "product"
        def price = null
        def mainImgUrl = "imageurl"
        def secondImgUrl = "imageurl"
        def thirdImgUrl = "imageurl"
        def videoUrl = "videourl"
        def shortDescription = "shortdescription"
        def descriptionPoints = ["point1", "point2", "point3"]
        def stock = 100
        def colour = "colour"
        def availableSizes = [1,2,3]
        def type = "type"

        def product = new Product(productName: productName, price: price, mainImgUrl: mainImgUrl, secondImgUrl: secondImgUrl,
                thirdImgUrl: thirdImgUrl, videoUrl: videoUrl, shortDescription: shortDescription,
                descriptionPoints: descriptionPoints, stock: stock, colour: colour, availableSizes: availableSizes,
                type: type)

        expect:"validation fails"
        false == product.validate()
    }

    void "Test validation of a incomplete product with no main image url"() {
        given: "no product main image url"

        def productName = "product"
        def price = 5.99
        def mainImgUrl = null
        def secondImgUrl = "imageurl"
        def thirdImgUrl = "imageurl"
        def videoUrl = "videourl"
        def shortDescription = "shortdescription"
        def descriptionPoints = ["point1", "point2", "point3"]
        def stock = 100
        def colour = "colour"
        def availableSizes = [1,2,3]
        def type = "type"

        def product = new Product(productName: productName, price: price, mainImgUrl: mainImgUrl, secondImgUrl: secondImgUrl,
                thirdImgUrl: thirdImgUrl, videoUrl: videoUrl, shortDescription: shortDescription,
                descriptionPoints: descriptionPoints, stock: stock, colour: colour, availableSizes: availableSizes,
                type: type)

        expect:"validation fails"
        false == product.validate()
    }

    void "Test validation of a incomplete product with no second image url"() {
        given: "no product second image url"

        def productName = "product"
        def price = 5.99
        def mainImgUrl = "imageurl"
        def secondImgUrl = null
        def thirdImgUrl = "imageurl"
        def videoUrl = "videourl"
        def shortDescription = "shortdescription"
        def descriptionPoints = ["point1", "point2", "point3"]
        def stock = 100
        def colour = "colour"
        def availableSizes = [1,2,3]
        def type = "type"

        def product = new Product(productName: productName, price: price, mainImgUrl: mainImgUrl, secondImgUrl: secondImgUrl,
                thirdImgUrl: thirdImgUrl, videoUrl: videoUrl, shortDescription: shortDescription,
                descriptionPoints: descriptionPoints, stock: stock, colour: colour, availableSizes: availableSizes,
                type: type)

        expect:"validation fails"
        false == product.validate()
    }

    void "Test validation of a incomplete product with no third image url"() {
        given: "no product third image url"

        def productName = "product"
        def price = 5.99
        def mainImgUrl = "imageurl"
        def secondImgUrl = "imageurl"
        def thirdImgUrl = null
        def videoUrl = "videourl"
        def shortDescription = "shortdescription"
        def descriptionPoints = ["point1", "point2", "point3"]
        def stock = 100
        def colour = "colour"
        def availableSizes = [1,2,3]
        def type = "type"

        def product = new Product(productName: productName, price: price, mainImgUrl: mainImgUrl, secondImgUrl: secondImgUrl,
                thirdImgUrl: thirdImgUrl, videoUrl: videoUrl, shortDescription: shortDescription,
                descriptionPoints: descriptionPoints, stock: stock, colour: colour, availableSizes: availableSizes,
                type: type)

        expect:"validation fails"
        false == product.validate()
    }

    void "Test validation of a incomplete product with no video url"() {
        given: "no product video url"

        def productName = "product"
        def price = 5.99
        def mainImgUrl = "imageurl"
        def secondImgUrl = "imageurl"
        def thirdImgUrl = "imageurl"
        def videoUrl = null
        def shortDescription = "shortdescription"
        def descriptionPoints = ["point1", "point2", "point3"]
        def stock = 100
        def colour = "colour"
        def availableSizes = [1,2,3]
        def type = "type"

        def product = new Product(productName: productName, price: price, mainImgUrl: mainImgUrl, secondImgUrl: secondImgUrl,
                thirdImgUrl: thirdImgUrl, videoUrl: videoUrl, shortDescription: shortDescription,
                descriptionPoints: descriptionPoints, stock: stock, colour: colour, availableSizes: availableSizes,
                type: type)

        expect:"validation fails"
        false == product.validate()
    }

    void "Test validation of a incomplete product with no shortDescription"() {
        given: "no product shortDescription"

        def productName = "product"
        def price = 5.99
        def mainImgUrl = "imageurl"
        def secondImgUrl = "imageurl"
        def thirdImgUrl = "imageurl"
        def videoUrl = "videourl"
        def shortDescription = null
        def descriptionPoints = ["point1", "point2", "point3"]
        def stock = 100
        def colour = "colour"
        def availableSizes = [1,2,3]
        def type = "type"

        def product = new Product(productName: productName, price: price, mainImgUrl: mainImgUrl, secondImgUrl: secondImgUrl,
                thirdImgUrl: thirdImgUrl, videoUrl: videoUrl, shortDescription: shortDescription,
                descriptionPoints: descriptionPoints, stock: stock, colour: colour, availableSizes: availableSizes,
                type: type)

        expect:"validation fails"
        false == product.validate()
    }

    void "Test validation of a incomplete product with no descriptionPoints"() {
        given: "no product descriptionPoints"

        def productName = "product"
        def price = 5.99
        def mainImgUrl = "imageurl"
        def secondImgUrl = "imageurl"
        def thirdImgUrl = "imageurl"
        def videoUrl = "videourl"
        def shortDescription = "shortdescription"
        def descriptionPoints = null
        def stock = 100
        def colour = "colour"
        def availableSizes = [1,2,3]
        def type = "type"

        def product = new Product(productName: productName, price: price, mainImgUrl: mainImgUrl, secondImgUrl: secondImgUrl,
                thirdImgUrl: thirdImgUrl, videoUrl: videoUrl, shortDescription: shortDescription,
                descriptionPoints: descriptionPoints, stock: stock, colour: colour, availableSizes: availableSizes,
                type: type)

        expect:"validation fails"
        false == product.validate()
    }

    void "Test validation of a incomplete product with no stock"() {
        given: "no product stock"

        def productName = "product"
        def price = 5.99
        def mainImgUrl = "imageurl"
        def secondImgUrl = "imageurl"
        def thirdImgUrl = "imageurl"
        def videoUrl = "videourl"
        def shortDescription = "shortdescription"
        def descriptionPoints = ["point1", "point2", "point3"]
        def stock = null
        def colour = "colour"
        def availableSizes = [1,2,3]
        def type = "type"

        def product = new Product(productName: productName, price: price, mainImgUrl: mainImgUrl, secondImgUrl: secondImgUrl,
                thirdImgUrl: thirdImgUrl, videoUrl: videoUrl, shortDescription: shortDescription,
                descriptionPoints: descriptionPoints, stock: stock, colour: colour, availableSizes: availableSizes,
                type: type)

        expect:"validation fails"
        false == product.validate()
    }

    void "Test validation of a incomplete product with no colour"() {
        given: "no product colour"

        def productName = "product"
        def price = 5.99
        def mainImgUrl = "imageurl"
        def secondImgUrl = "imageurl"
        def thirdImgUrl = "imageurl"
        def videoUrl = "videourl"
        def shortDescription = "shortdescription"
        def descriptionPoints = ["point1", "point2", "point3"]
        def stock = 100
        def colour = null
        def availableSizes = [1,2,3]
        def type = "type"

        def product = new Product(productName: productName, price: price, mainImgUrl: mainImgUrl, secondImgUrl: secondImgUrl,
                thirdImgUrl: thirdImgUrl, videoUrl: videoUrl, shortDescription: shortDescription,
                descriptionPoints: descriptionPoints, stock: stock, colour: colour, availableSizes: availableSizes,
                type: type)

        expect:"validation fails"
        false == product.validate()
    }

    void "Test validation of a incomplete product with no availableSizes"() {
        given: "no product availableSizes"

        def productName = "product"
        def price = 5.99
        def mainImgUrl = "imageurl"
        def secondImgUrl = "imageurl"
        def thirdImgUrl = "imageurl"
        def videoUrl = "videourl"
        def shortDescription = "shortdescription"
        def descriptionPoints = ["point1", "point2", "point3"]
        def stock = 100
        def colour = "colour"
        def availableSizes = null
        def type = "type"

        def product = new Product(productName: productName, price: price, mainImgUrl: mainImgUrl, secondImgUrl: secondImgUrl,
                thirdImgUrl: thirdImgUrl, videoUrl: videoUrl, shortDescription: shortDescription,
                descriptionPoints: descriptionPoints, stock: stock, colour: colour, availableSizes: availableSizes,
                type: type)

        expect:"validation fails"
        false == product.validate()
    }

    void "Test validation of a incomplete product with no type"() {
        given: "no product type"

        def productName = "product"
        def price = 5.99
        def mainImgUrl = "imageurl"
        def secondImgUrl = "imageurl"
        def thirdImgUrl = "imageurl"
        def videoUrl = "videourl"
        def shortDescription = "shortdescription"
        def descriptionPoints = ["point1", "point2", "point3"]
        def stock = 100
        def colour = "colour"
        def availableSizes = [1,2,3]
        def type = null

        def product = new Product(productName: productName, price: price, mainImgUrl: mainImgUrl, secondImgUrl: secondImgUrl,
                thirdImgUrl: thirdImgUrl, videoUrl: videoUrl, shortDescription: shortDescription,
                descriptionPoints: descriptionPoints, stock: stock, colour: colour, availableSizes: availableSizes,
                type: type)

        expect:"validation fails"
        false == product.validate()
    }
}
