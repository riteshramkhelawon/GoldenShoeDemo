package goldenshoe

class OrdersMade {
    String orderNumber
    String customer
    Map<String, String> productSize
    Map<String, String> productQuantity

    static constraints = {
        orderNumber nullable: false, unique: true
        customer nullable: false
        productSize nullable: false
    }
}
