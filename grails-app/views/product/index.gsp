<!DOCTYPE html>
<html xmlns:g="http://www.w3.org/1999/html">
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
        <title><g:message code="default.list.label" args="[entityName]" /></title>
    </head>
    <body>
    <script>
        function addToBasket(productName, size, quantity){
            if(size){
                $('#addToBasketBtn').addClass('hidden');$('#basketMessage').removeClass('hidden');
                $('#basketMessage').delay(2500).fadeOut('slow');

                var URL="${createLink(controller:'cart', action:'addToCart')}";
                console.log("ajax call JS");
                $.ajax({
                       url: URL,
                       data: {item: productName, size: size, quantity: quantity},
                       success: function(resp){
                       console.log("ajax call done");
                   }
                });
            } else {
                alert('Please select a size before adding to the basket');
            }
        }

        function findSize(mostUsedBrand, footShape, usualSize){
            var URL="${createLink(controller:'product', action:'findSize')}";
            console.log("ajax call find size");
            $.ajax({
                   url: URL,
                   data: {mostUsedBrand: mostUsedBrand, footShape: footShape, usualSize: usualSize},
                   success: function(resp){
                        console.log("ajax call size found: " + resp);
                        $('#recommendedSize').html(resp);
               }
            });
        }
    </script>
        <section id="productInfo" class="container">
            <h1>${product.productName}</h1>
            <hr>
            <div class="row pl-0">
                <div class="col-md-5">
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
                    <hr>
                    <div class="pl-0 row">
                        <div class="col-6">
                            <h4>Available in sizes: </h4>
                            <select required id="selectSize" class="btn btn-info">
                                <option selected="selected" disabled>Select a size</option>
                                <g:each var="size" in="${product.availableSizes}">
                                    <option class="dropdown-item" value="${size}">${size}</option>
                                </g:each>
                            </select>
                            <br><br>
                            <div>
                                <button type="button" class="btn btn-secondary" data-toggle="modal" data-target="#exampleModalCenter">
                                    Find your size
                                </button>
                            </div>
                            <input type="hidden" name="size" id="chosenSize" />
                        </div>

                        <div class="col-6">
                            <g:if test="${product.stock > 0}">
                                <h4>Quantity:</h4><input type="number" name="quantity" id="quantity" min="1" max="${product.stock}" value="1"/>
                            </g:if>

                        </div>
                    </div>
                    <hr>
                    <h4>Description</h4>
                    <ul class="ml-4" style="line-height: 2;">
                        <g:each var="bulletPoint" in="${product.descriptionPoints}">
                            <li>${bulletPoint}</li>
                        </g:each>
                    </ul>
                    <br>
                    <h4 style="color: firebrick"><em><b>Price: £<span><g:formatNumber number="${product.price}" type="currency" currencySymbol=""/></span></b></em></h4>
                    <g:if test="${product.stock > 0}">
                        <small class="text-success"><strong><em>In stock: ${product.stock}</em></strong></small>
                        <br><br>
                        <button id="addToBasketBtn" class="btn btn-info" type="button" onclick="addToBasket('${product.productName}', $('#chosenSize').val(), $('#quantity').val())">Add to Basket</button>
<!--                        <button class="btn btn-info" type="button">Buy Now</button>-->
                    </g:if>
                    <g:else>
                        <small class="text-danger"><strong><em>Sorry this item is out of stock</em></strong></small>
                    </g:else>


                    <br><br>
                    <div id="basketMessage" class="alert alert-success hidden">
                        <h5>Added to basket</h5>
                    </div>
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

    <!-- Modal -->
    <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="bg-info modal-header">
                    <div class="ml-auto">
                        <h3 class="text-center modal-title text-light" id="exampleModalLongTitle">Let's find your size</h3>
                    </div>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                        <label for="mostUsedBrand">Which brand of shoe do you wear most often?</label>
                        <br>
                        <select class="form-control" id="mostUsedBrand" name="mostUsedBrand">
                            <option value="Adidas">Adidas</option>
                            <option value="Nike">Nike</option>
                            <option value="Reebok">Reebok</option>
                        </select>
                        <br><br>
                        <label for="footShape">How would you describe your foot shape?</label>
                        <br>
                        <select class="form-control" id="footShape" name="footShape">
                            <option value="Narrow">Narrow</option>
                            <option value="Average">Average</option>
                            <option value="Wide">Wide</option>
                        </select>
                        <br><br>
                        <label for="usualSize">Which size do you usually wear?</label>
                        <br>
                        <select class="form-control" id="usualSize" name="footShape">
                            <g:each var="size" in="${(4..<12)}">
                                <option value="${size}" name="usualSize">Size ${size}</option>
                            </g:each>
                        </select>
                </div>
                <div class="bg-info modal-footer">
                    <div class="text-center mx-auto">
                        <button onclick="findSize($('#mostUsedBrand').val(),$('#footShape').val(),$('#usualSize').val());" type="button" class="btn btn-light" >Find your size</button>
                        <h3>Your recommended size is: <strong id="recommendedSize"></strong></h3>
                    </div>
                </div>
            </div>
        </div>
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

                $('#selectSize').change(function(){
                    var size = $(this).val();
                    $('#chosenSize').val(size);
                    console.log($('#chosenSize').val());
                })


        });
    </script>

    </body>


</html>