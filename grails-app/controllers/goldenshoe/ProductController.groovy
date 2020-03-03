package goldenshoe

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import groovy.sql.Sql

class ProductController {

    def dataSource

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        //retrieve the product from the database
        def product = Product.findByProductName(params.productName)

        render(view: "index", model: [product: product])

    }

    def findSize(){
        def sql = new Sql(dataSource)
        def mostUsedBrand = params.mostUsedBrand
        def footShape = params.footShape
        def usualSize = params.usualSize

        //SQL query to obtain the appropriate recommended size from the database, given the user inputs
        def recommendationRow = sql.rows("SELECT recommendation FROM recommended_size WHERE brand='"+mostUsedBrand+
                "' AND shape='"+footShape+"' AND usual_size="+usualSize)

        sql.close()

        //if a recommendation is found, get the value
        //otherwise notify the user that a recommended size was not found
        if (recommendationRow.size() > 0){
            def recommendationValue = recommendationRow.collect{it.values()}.get(0)
            render recommendationValue.max()
        } else {
            render "Size not found"
        }
    }
}
