<!doctype html>
<html>
<head>
    <title>Golden Shoe | Track Order</title>
    <meta name="layout" content="main">
    <script src="/assets/trackOrder.js"></script>
</head>
<body>

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
