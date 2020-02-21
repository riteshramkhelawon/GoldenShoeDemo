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
                        <div class="col-md-3">
                            <img class="thumbnailImg" onclick="$('#largeImgDiv').attr('src','${product.mainImgUrl}');" width="100px" src="${product.mainImgUrl}" />
                        </div>
                        <div class="col-md-3">
                            <img class="thumbnailImg" onclick="$('#largeImgDiv').attr('src','${product.secondImgUrl}');" width="100px"  src="${product.secondImgUrl}" />
                        </div>
                        <div class="col-md-3">
                            <img class="thumbnailImg" onclick="$('#largeImgDiv').attr('src','${product.thirdImgUrl}');" width="100px"  src="${product.thirdImgUrl}" />
                        </div>
                        <div class="col-md-3">
                            <a class="thumbnails" id="video"><i class='m-3 far fa-play-circle fa-4x'></i></a>
                        </div>
                    </div>

                    <small>In stock: ${product.stock}</small>
                </div>
                <div class="col-md-5">
                    <div class="container">
                        <img width="60%" id="largeImgDiv" src="${product.mainImgUrl}" />
                        <div class="hidden" id="largeVidDiv">
                            <iframe width="60%" height="345" src=${product.videoUrl} allowfullscreen></iframe>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <div>
            <button type="button">Buy Now</button>
        </div>

    <style>
        .thumbnails a,img:hover{
            cursor: grab;
        }
    </style>

    <script>
        $(document).ready(
            function(){
                $(".thumbnailImg").click(function(){
                    $('iframe').attr('src', $('iframe').attr('src'));
                    $('#largeVidDiv').addClass('hidden');
                    $("#largeImgDiv").removeClass('hidden');
                });

                $("#video").click(function(){
                    $('#largeVidDiv').removeClass('hidden');
                    $("#largeImgDiv").addClass('hidden');
                });
        });
    </script>

    </body>


</html>