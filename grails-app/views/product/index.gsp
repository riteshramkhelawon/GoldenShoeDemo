<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
        <!-- lightbox -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.css" rel="stylesheet">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/ekko-lightbox/5.3.0/ekko-lightbox.js"></script>
    </head>
    <body>
        <section class="container">
            <h1>${product.productName}</h1>
            <hr>
            <div class="row">
                <div class="col-md-5">
                    <h2 style="color: firebrick"><em><b>Price: £<span><g:formatNumber number="${product.price}" type="currency" currencySymbol=""/></span></b></em></h2>
                    <h3>${product.description}</h3>
                    <h3>${product.availableSizes}</h3>

                    <div class="thumbnails row justify-content-center">
                        <div class="col-md-4">
                            <img class="thumbnailImg" onclick="$('#largeImgDiv').attr('src','${product.mainImgUrl}');" width="100px" src="${product.mainImgUrl}" />
                        </div>
                        <div class="col-md-4">
                            <img class="thumbnailImg" onclick="$('#largeImgDiv').attr('src','${product.secondImgUrl}');" width="100px"  src="${product.secondImgUrl}" />
                        </div>
                        <div class="col-md-4">
                            <img class="thumbnailImg" onclick="$('#largeImgDiv').attr('src','${product.thirdImgUrl}');" width="100px"  src="${product.thirdImgUrl}" />
                        </div>
                    </div>

                    <small>In stock: ${product.stock}</small>
                </div>
                <div class="col-md-5">
                    <div class="container">
                        <img width="60%" id="largeImgDiv" src="${product.mainImgUrl}" />
                    </div>
                </div>
            </div>
        </section>

        <div>
            <button type="button">Buy Now</button>
        </div>

    <style>
        .thumbnails img:hover{
            cursor: grab;
        }
    </style>

    </body>


</html>