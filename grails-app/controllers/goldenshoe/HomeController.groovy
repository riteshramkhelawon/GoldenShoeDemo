package goldenshoe

class HomeController {



    def index() {
        def products = Product.findAll()

        if (!session.getAttribute("CART")){
            session.setAttribute("CART", new ArrayList<Product>())
            println("cart created")
        } else {
            println("cart already exists")
        }


        render(view: "index", model: [products: products])

    }
}
