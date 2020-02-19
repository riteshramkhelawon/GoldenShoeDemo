package goldenshoe

class Product {
     String productName
     Double price
     String mainImgUrl
     String secondImgUrl
     String thirdImgUrl
     String description
     int stock
     String colour
     int[] availableSizes
     String type

    static constraints = {
        productName nullable: false, unique: true
        price nullable: false
        mainImgUrl nullable: false, unique: true
        secondImgUrl nullable: false, unique: true
        thirdImgUrl nullable: false, unique: true
        description nullable: false, unique: true, maxSize: 250
        stock nullable: false
        colour nullable: false
        availableSizes nullable: false
        type nullable: false
    }
}
