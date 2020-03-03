<!DOCTYPE html>
<html lang="en" xmlns:g="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="layout" content="main" />
    <title>Golden Shoe | Order Confirmation</title>
</head>
    <section id="orderNo" class="container">
        <div class="text-center text-secondary">
            <h1>Thank you for ordering with Golden Shoe</h1>
            <h2 class="text-dark">Order Number: <span>${order.orderNumber}</span></h2>
            <small>Please keep note of this order number for use during any enquiries</small>
        </div>
    </section>

    <hr>

    <section id="orderedItems" class="container">
        <table class="table table-sm table-hover">
            <thead>
            <tr>
                <th>Product</th>
                <th>Size</th>
                <th>Quantity</th>
                <th>Price</th>
            </tr>
            </thead>
            <tbody>
            <g:each var="cartProduct" in="${order.products}">
                <tr>
                    <td><h4>${cartProduct.product.productName}</h4></td>
                    <td><h4>${cartProduct.size}</h4></td>
                    <td><h4>${cartProduct.quantity}</h4></td>
                    <td><h4>£<g:formatNumber number="${cartProduct.product.price}" type="currency" currencySymbol=""/></h4></td>
                </tr>
            </g:each>
                <tr>
                    <td></td>
                    <td></td>
                    <td class="text-right"><h4><strong>Total<g:if test="${wasVoucherApplied}"> (with discount)</g:if>:</strong></h4></td>
                    <td><h4><strong>£<g:formatNumber number="${totalPrice}" type="currency" currencySymbol=""/></strong></h4></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
    </section>

    <section id="orderDetails" class="container">
        <div class="container">
            <h3>Estimated Delivery Date: <strong><g:formatDate date="${new Date()+3}" type="date" style="FULL"/></strong></h3>
            <br>
            <h3>Delivering to <strong>${customerName}</strong></h3>
            <h3>${customerAddress}</h3>
            <br><br>
            <small>We may contact you on <strong>${mobile}</strong> if there any issues with your order</small>
        </div>
        <br>
        <form class="text-center " action="/cart/clearCart">
            <button class="btn btn-info" type="submit">Continue</button>
        </form>
    </section>
</body>
</html>