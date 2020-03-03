package goldenshoe

import grails.core.GrailsApplication
import org.grails.web.json.JSONObject

class FaqController {

    GrailsApplication grailsApplication

    def faqReply(){
        //generate api url using base url + user input (and replacing spaces)
        def userQuestion = params.userQuestion.replaceAll(" ", "%20")
        def queryUrl = grailsApplication.config.getProperty('witAi.baseUrl') + userQuestion
        def accessToken = grailsApplication.config.getProperty('witAi.accessToken')

        //get the recognised intent from the wit.ai API, given the user query
        def returnedIntent = witAiApiCall(queryUrl, accessToken)
        //get the appropriate response to the user, given the intent
        def response = getResponse(returnedIntent)

        render response
    }

    static String witAiApiCall(String queryUrl, String accessToken){
        def intent = "none"

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

            if (jsonResponse.entities.intent){
                intent = jsonResponse.entities.intent.value.get(0)
            }

            connection.disconnect()

            return intent
        } catch (MalformedURLException e) {
            e.printStackTrace()
            return intent
        } catch (IOException e) {
            e.printStackTrace()
            return intent
        }
    }

    static String getResponse(String intent){
        //return the appropriate response to the user, based on the intent returned from the wit.ai api
        if (intent == "returns"){
            return "To return an item, please send the item back to:<br>Golden Shoe<br>14 Shoe Street<br>N18 7RT.<br><br>" +
                    "Upon receiving your item, we will issue a full refund to the account used to pay for the item."
        } else if (intent == "trackOrder"){
            return "To track the current status of your order, please visit the order tracking page <a href=\"/trackOrder\"" +
                    ">here</a>"
        } else {
            return "Sorry, please call our customer service team on weekdays between 9am and 5pm<br> for an answer to your" +
                    " query"
        }
    }
}

