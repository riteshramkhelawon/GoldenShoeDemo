function addToBasket(productName, size, quantity, stock){
    if(quantity <= stock){
        if(size){
            $('#basketMessage').removeClass('hidden');
            $('#basketMessage').delay(2500).fadeOut('slow');

            var URL="/cart/addToCart";

            $.ajax({
                   url: URL,
                   data: {item: productName, size: size, quantity: quantity},
                   success: function(resp){
               }
            });
        } else {
            alert('Please select a size before adding to the basket');
        }
    } else {
        alert('There is not enough stock for this quantity');
    }
}

function findSize(mostUsedBrand, footShape, usualSize){
    var URL="/product/findSize";

    $.ajax({
           url: URL,
           data: {mostUsedBrand: mostUsedBrand, footShape: footShape, usualSize: usualSize},
           success: function(resp){
                $('#recommendedSize').html(resp);
       }
    });
}
