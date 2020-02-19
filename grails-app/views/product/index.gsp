<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
        <section class="container">
            <h1>${product.productName}</h1>
            <hr>
            <h2 style="color: firebrick"><em><b>Price: £<span><g:formatNumber number="${product.price}" type="currency" currencySymbol=""/></span></b></em></h2>
            <h3>${product.description}</h3>
            <h3>${product.availableSizes}</h3>

            <small>In stock: ${product.stock}</small>


            <img src="${product.mainImgUrl}" />
        </section>

    <div>
        <button type="button">Buy Now</button>
    </div>


    </body>


</html>