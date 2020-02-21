package goldenshoe

class BootStrap {

    def init = { servletContext ->

        def yeezy = new Product(
                productName : "Yeezys",
                price : 500.50,
                description : "Kanye West's new Yeezy boots from his new collection.",
                stock : 100 ,
                colour : "grey",
                availableSizes : [8, 9, 10],
                type : "stylish",
                mainImgUrl : "/assets/shoes/yeezy-main.jpg",
                secondImgUrl : "/assets/shoes/yeezy-second.jpg",
                thirdImgUrl : "/assets/shoes/yeezy-third.jpg",
                videoUrl: "https://www.youtube.com/embed/ruYWz8L2IcQ"
        ).save()

        def heels = new Product(
                productName : "Heel Shoes",
                price : 44.99,
                description : "High heel leather shoes. Manufactured by a major fashion company in Italy",
                stock : 20 ,
                colour : "Red",
                availableSizes : [5, 7, 8],
                type : "heels",
                mainImgUrl : "/assets/shoes/heels-main.jpg",
                secondImgUrl : "/assets/shoes/heels-second.jpg",
                thirdImgUrl : "/assets/shoes/heels-third.jpg",
                videoUrl: "https://www.youtube.com/embed/u6jKPojkhmY"
        ).save()

        def adidas = new Product(
                productName : "Adidas Classics",
                price : 70.00,
                description : "New Adidas classic black running shoes from their sports collection.",
                stock : 75 ,
                colour : "Black",
                availableSizes : [7, 9, 11],
                type : "trainers",
                mainImgUrl : "/assets/shoes/adidas-main.jpg",
                secondImgUrl : "/assets/shoes/adidas-second.jpg",
                thirdImgUrl : "/assets/shoes/adidas-third.jpg",
                videoUrl: "https://www.youtube.com/embed/_sIaPgpM2v0"
        ).save()



    }

    def destroy = {

    }

}
