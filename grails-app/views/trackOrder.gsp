<!doctype html>
<html>
<head>
    <title>Track Your Order</title>
    <meta name="layout" content="main">
</head>
<body>
    <script>
        function trackOrder(orderNumber){
            var URL="${createLink(controller:'customerOrder', action:'trackOrder')}";
            console.log("ajax call - track");
            $.ajax({
                   url: URL,
                   data: {orderNumber: orderNumber},
                   success: function(resp){
                        console.log("ajax track done");

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
    </script>

    <div class="text-center container">
        <div class="container">
            <h1 class="text-secondary">Track Your Order</h1>
            <h3>Enter your order number below</h3>
            <small>Please make sure you enter the correct order number (case sensitive)</small>
            <br><br>
            <input type="text" id="orderNumber" name="orderNumber" />
            <button onclick="trackOrder($('#orderNumber').val());" type="button" class="btn btn-info">Track Order</button>
            <br><br>
            <h3 class="hidden" id="orderStatus"></h3>
        </div>

    </div>
</body>
</html>
