package goldenshoe

class CustomerOrder {
    String orderNumber
    List<CartProduct> products
    String customerName
    String customerAddress
    String customerTelephone
    String status
    Date dateCreated


    static constraints = {
        orderNumber nullable: false
        products nullable: false
        customerName nullable: false
        customerAddress nullable: false
        customerTelephone nullable: false
        status nullable: false
    }
}
