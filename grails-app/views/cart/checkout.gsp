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
                        <td><h4>Size</h4></td>
                        <td><h4>Quantity</h4></td>
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
</body>
</html>