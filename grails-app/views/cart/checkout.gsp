<!DOCTYPE html>
<html xmlns:g="http://www.w3.org/1999/html">
<head>
    <meta name="layout" content="main" />
    <g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
    <script src="/assets/checkout.js"></script>
    <title><g:message code="default.list.label" args="[entityName]" /></title>
</head>
<body>
    <section id="cartContents" class="container">
        <h1>Your Basket</h1>
        <hr>
        <g:if test="${cart}">
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
                            <td><h4>${cartItem.product.productName}</h4></td>
                            <td><h4>${cartItem.size}</h4></td>
                            <td><h4>${cartItem.quantity}</h4></td>
                            <td><h4>£<g:formatNumber number="${cartItem.product.price}" type="currency" currencySymbol=""/></h4></td>
                            <td>
                                <form action="/cart/removeFromCart">
                                    <input type="hidden" name="item" value="${cartItem.id}" />
                                    <button type="submit" class="btn ml-0 pl-0 " style="background-color: transparent;"><i class="fas fa-trash-alt text-danger"></i></button>
                                </form>
                            </td>
                        </tr>
                    </g:each>
                        <tr>
                            <td></td>
                            <td></td>
                            <td class="text-right"><h4><strong>Total:</strong></h4></td>
                            <td><h4><strong>£<g:formatNumber number="${totalPrice}" type="currency" currencySymbol=""/></strong></h4></td>
                            <td></td>
                        </tr>
                        <tr id="discountedTotalTableRow" class="hidden">
                            <td></td>
                            <td></td>
                            <td class="text-right text-info"><h4><strong>Discounted Total:</strong></h4></td>
                            <td><h4><strong>£</strong><strong id="discountedTotal"><g:formatNumber number="${totalPrice}" type="currency" currencySymbol=""/></strong></h4></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>

                <div>
                    <h4>Have a voucher code? Enter your code here to get a discount!</h4>
                    <input class="" type="text" name="voucherCode" id="voucherCode" />
                    <button id="applyCodeBtn" type="button" class="btn btn-info" onclick="applyVoucherCode($('#voucherCode').val(), ${totalPrice});">Apply Code</button>
                    <br>
                    <small class="hidden text-success" id="validVoucherCode">Voucher Code Applied</small>
                    <small class="hidden text-danger" id="invalidVoucherCode">Sorry, this voucher code is not valid</small>
                </div>
            </g:if>
            <g:else>
                <h5>There are no items in your basket</h5>
            </g:else>
        </g:if>
        <g:else>
            <h5>There are no items in your basket</h5>
        </g:else>

    </section>
    <g:if test="${cart}">
        <g:if test="${cart.size() > 0}">
            <hr>

            <section id="userDetails" class="container">
                <form action="/customerOrder/completeOrder">
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
                        <button class="btn btn-info" type="submit">Checkout & Pay</button>
                    </div>
                    <input type="hidden" id="discountedTotalHidden" name="discountedTotalHidden" value="${totalPrice}"/>
                    <input type="hidden" id="wasVoucherApplied" name="wasVoucherApplied" value="false"/>
                </form>
            </section>
        </g:if>
    </g:if>
</body>
</html>