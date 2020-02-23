<!DOCTYPE html>
<html xmlns:g="http://www.w3.org/1999/html">
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
    <section id="cartContents" class="container">
        <h1>Your Basket</h1>
        <hr>
        <g:if test="${cart.size() > 0}">
            <table class="table table-sm table-hover">
                <thead>
                <tr>
                    <th>Product</th>
                    <th>Size</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <g:each var="cartItem" in="${cart}">
                    <tr>
                        <td><h4>${cartItem.productName}</h4></td>
                        <td><h4>${cartItem.availableSizes[0]}</h4></td>
                        <td><h4><input type="number" min="1" max="10"></h4></td>
                        <td><h4>£<g:formatNumber number="${cartItem.price}" type="currency" currencySymbol=""/></h4></td>
                        <td>
                            <form action="/cart/removeFromCart">
                                <input type="hidden" name="item" value="${cartItem.productName}" />
                                <button type="submit" class="btn" style="background-color: transparent;"><i class="fas fa-trash-alt fa-2x text-danger"></i></button>
                            </form>
                        </td>
                    </tr>
                </g:each>
                </tbody>
            </table>
        </g:if>
        <g:else>
            <h5>There are no items in your basket</h5>
        </g:else>
    </section>

    <hr>

    <section id="userDetails" class="container">
        <div class="row">
            <div class="col-md-6">
                <h2 class="text-secondary">Your Details</h2>
                <label class="mb-3" for="name">Full name:</label><br><input class="mb-3" type="text" id="name" name="name" /><br>
                <label class="mb-3" for="mobile">Telephone:</label><br><input class="mb-3" type="text" id="mobile" name="mobile" /><br>
                <label class="mb-3" for="addressLine1">Address Line 1:</label><br><input class="mb-3" type="text" id="addressLine1" name="addressLine1" /><br>
                <label class="mb-3" for="postcode">Post Code:</label><br><input class="mb-3" type="text" id="postcode" name="postcode" />
            </div>

            <div class="col-md-6">
                <h2 class="text-secondary">Payment Details</h2>
                <label class="mb-3" for="carholder">Cardholder's Name:</label><br><input class="mb-3" type="text" id="carholder" name="carholder" /><br>
                <label class="mb-3" for="cardNo">Card Number:</label><br><input class="mb-3" type="text" id="cardNo" name="cardNo" /><br>
                <label class="mb-3" for="expDate">Expiry Date:</label><br><input class="mb-3" type="text" id="expDate" name="expDate" /><br>
                <label class="mb-3" for="ccv">CCV:</label><br><input class="mb-3" type="text" id="ccv" name="ccv" /><br><br>
            </div>
        </div>
        <div class="text-center">
            <form action="/cart/completeOrder">
                <button class="btn btn-info" type="submit">Checkout & Pay</button>
            </form>
        </div>
    </section>
</body>
</html>