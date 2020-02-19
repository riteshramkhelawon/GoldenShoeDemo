package goldenshoe

class HomeController {

    def index() {
        def products = Product.findByProductName("Yeezys")

        render(view: "index", model: [products: products])

    }
}
