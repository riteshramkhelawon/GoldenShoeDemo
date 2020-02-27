package goldenshoe

import org.grails.web.json.JSONObject

class HomeController {

    def index() {
        def products = Product.findAll()

        if (!session.getAttribute("CART")){
            session.setAttribute("CART", new ArrayList<CartProduct>())
            println("cart created")
        } else {
            println("cart already exists")
        }

        render(view: "index", model: [products: products])

    }

    def faqReply(){
        def userQuestion = params.userQuestion.replaceAll(" ", "%20")
        def queryUrl = "https://api.wit.ai/message?v=20200227&q=" + userQuestion
//        def appId = "720598341678675"
        def accessToken = "U46SWUWU2SXC6SEXE7545N3272F7QWWS"
        try {
            URL url = new URL(queryUrl)
            HttpURLConnection connection = (HttpURLConnection) url.openConnection()
            connection.setRequestMethod("GET")

            connection.setRequestProperty("Content-Type", "application/json")
            connection.setRequestProperty("Authorization", "Bearer " + accessToken)

            connection.setConnectTimeout(5000)
            connection.setReadTimeout(5000)

            if (connection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + connection.getResponseCode())
            }

            StringBuilder stringBuilder = new StringBuilder()

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (connection.getInputStream())))

            String output
            while ((output = br.readLine()) != null) {
                stringBuilder.append(output)
            }

            JSONObject jsonResponse = new JSONObject(stringBuilder.toString())
            def intent = jsonResponse.entities.intent.value.get(0)


            def answer = getResponse(intent)

            connection.disconnect()

            render answer

        } catch (MalformedURLException e) {

            e.printStackTrace()

        } catch (IOException e) {

            e.printStackTrace()

        }

    }

    static String getResponse(String intent){
        if (intent == "returns"){
            return "To return an item, please send the item back to:<br>Golden Shoe<br>14 Shoe Street<br>N18 7RT.<br><br>" +
                    "Upon receiving your item, we will issue a full refund to the account used to pay for the item."
        } else if (intent == "trackOrder"){
            return "To track the current status of your order, please visit the order tracking page <a href=\"/trackOrder\"" +
                    ">here</a>"
        }
    }


}
