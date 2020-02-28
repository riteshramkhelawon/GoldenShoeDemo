package goldenshoe

class CartProduct {
    Product product
    Integer size
    Integer quantity


    static constraints = {
        product nullable: false
        size nullable: false
        quantity nullable: false
    }
}
