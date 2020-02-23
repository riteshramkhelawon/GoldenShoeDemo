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
        <g:each var="cartItem" in="${cart}">
            <h3>${cartItem.productName}</h3>
        </g:each>
    </section>
</body>
</html>