function trackOrder(orderNumber){
    var URL="/customerOrder/trackOrder";

    $.ajax({
       url: URL,
       data: {orderNumber: orderNumber},
       success: function(resp){
            if(resp.valid){
                $('#orderStatus').removeClass('hidden')
                $('#orderStatus').html("Your order is currently: "+resp.status)
                $('#orderStatus').css('color', 'green');
            } else {
                $('#orderStatus').removeClass('hidden')
                $('#orderStatus').html("Sorry this order number was not found")
                $('#orderStatus').css('color', 'red');
            }
       }
    });
}

