package goldenshoe

import org.grails.web.json.JSONObject

class HomeController {

    def index() {
        //get all products in the database
        def products = Product.findAll()

        //if there is no current 'cart' within the session, create a new 'cart'
        if (!session.getAttribute("CART")) {
            session.setAttribute("CART", new ArrayList<CartProduct>())
        }

        render(view: "index", model: [products: products])
    }
}