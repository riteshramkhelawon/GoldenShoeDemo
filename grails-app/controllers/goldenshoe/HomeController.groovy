package goldenshoe

class HomeController {

    def index() {
        def products = Product.findAll()

        render(view: "index", model: [products: products])

    }
}
