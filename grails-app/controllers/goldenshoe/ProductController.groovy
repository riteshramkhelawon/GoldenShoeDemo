package goldenshoe

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import groovy.sql.Sql

class ProductController {

    ProductService productService
    def dataSource

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        println("name: ${params.productName}")
        def product = Product.findByProductName(params.productName)

        render(view: "index", model: [product: product])

    }

    def findSize(){
        def sql = new Sql(dataSource)
        def mostUsedBrand = params.mostUsedBrand
        def footShape = params.footShape
        def usualSize = params.usualSize

        println("find size: "+mostUsedBrand+", "+footShape+", "+usualSize)

        def recommendationRow = sql.rows("SELECT recommendation FROM recommended_size WHERE brand='"+mostUsedBrand+"' AND shape='"+footShape+"' AND usual_size="+usualSize)
//
        sql.close()

        if (recommendationRow.size() > 0){
            def recommendationValue = recommendationRow.collect{it.values()}.get(0)
            println("rec: "+recommendationValue)

            render recommendationValue.max()
        } else {
            render "Size not found"
        }
    }

    def show(Long id) {
        respond productService.get(id)
    }

    def create() {
        respond new Product(params)
    }

    def save(Product product) {
        if (product == null) {
            notFound()
            return
        }

        try {
            productService.save(product)
        } catch (ValidationException e) {
            respond product.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'product.label', default: 'Product'), product.id])
                redirect product
            }
            '*' { respond product, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond productService.get(id)
    }

    def update(Product product) {
        if (product == null) {
            notFound()
            return
        }

        try {
            productService.save(product)
        } catch (ValidationException e) {
            respond product.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'product.label', default: 'Product'), product.id])
                redirect product
            }
            '*'{ respond product, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        productService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'product.label', default: 'Product'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'product.label', default: 'Product'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
