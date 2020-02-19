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
                mainImgUrl : "YEEZYmainImgUrl",
                secondImgUrl : "YEEZYsecondImgUrl",
                thirdImgUrl : "YEEZYthirdImgUrl"
        ).save()

        def heels = new Product(
                productName : "Heel Shoes",
                price : 44.99,
                description : "High heel shoes imported directly from Italy.",
                stock : 20 ,
                colour : "Red",
                availableSizes : [5, 7, 8],
                type : "heels",
                mainImgUrl : "HEELSmainImgUrl",
                secondImgUrl : "HEELSsecondImgUrl",
                thirdImgUrl : "HEELSthirdImgUrl"
        ).save()

        def adidas = new Product(
                productName : "Adidas Classics",
                price : 70.00,
                description : "New Adidas classic black running shoes frm their sports collection.",
                stock : 75 ,
                colour : "Black",
                availableSizes : [7, 9, 11],
                type : "trainers",
                mainImgUrl : "TRAINERSmainImgUrl",
                secondImgUrl : "TRAINERSsecondImgUrl",
                thirdImgUrl : "TRAINERSthirdImgUrl"
        ).save()



    }

    def destroy = {

    }

}
