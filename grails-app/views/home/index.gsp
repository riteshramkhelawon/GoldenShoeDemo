<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <link rel="stylesheet" type="text/css" href="/assets/home.css">
    <title>Golden Shoe</title>
</head>
<body>
    <section id="mainImagesSlider" class="text-center">
        <div id="myCarousel" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner">
                <div class="item active">
                    <img src="/assets/shoes/orange.jpg" alt="Firefly Shoes" style="width:100%;">
                </div>

                <div class="item">
                    <img src="/assets/shoes/diff-colour-shoes.jpg" alt="Different Coloured Shoes" style="width:100%;">
                </div>

                <div class="item">
                    <img src="/assets/shoes/boots.jpg" alt="Boots" style="width:100%;">
                </div>
            </div>

            <!-- Left and right controls -->
            <a class="left carousel-control" href="#myCarousel" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </section>

    <section id="topProducts" class="container">
        <h1 class="text-center text-secondary"><strong>Top Products</strong></h1>

        <div class="card-group">
            <g:each var="product" in="${products}">
                <div class="thumbnail card m-md-3" style="border-left: 1px solid rgba(0, 0, 0, 0.125);">
                    <img src="${product.mainImgUrl}" class="card-img-top" alt="...">
                    <div class="text-center card-body">
                        <h4 class="card-title"><strong>${product.productName}</strong></h4>
                        <p class="card-text">${product.shortDescription}</p>
                        <p class="card-text" style="color: firebrick;"><strong>£<g:formatNumber number="${product.price}" type="currency" currencySymbol=""/>
                        </strong></p>
                        <small>Available in ${product.colour}</small>
                        <br>
                        <g:if test="${product.stock > 0}">
                            <small class="text-success"><em><strong>In Stock</strong></em></small>
                        </g:if>
                        <g:else>
                            <small class="text-danger"><em><strong>Out of Stock</strong></em></small>
                        </g:else>

                        <br><br>
                        <form action="/product/index" method="get">
                            <input type="hidden" name="productName" value="${product.productName}">
                            <button class="btn btn-info btn-block" type="submit">View</button>
                        </form>
                    </div>
                </div>
            </g:each>
        </div>
    </section>

    <hr class="container">

    <section id="about" class="container">
        <h2 class="text-secondary text-center"></h2>
        <div class="row">
            <div class="col-md-4 text-center">
                <h3>Shipping</h3>
                <br>
                <i class="fas fa-shipping-fast fa-5x"></i>
                <br><br>
                <h5>Fast, reliable and dedicated shipping. Straight to your door.</h5>
            </div>
            <div class="col-md-4 text-center">
                <h3>Gift Wrapping</h3>
                <br>
                <i class="fas fa-gift fa-5x"></i>
                <br><br>
                <h5>Get your shoes gift wrapped personally by us. Perfect for any occasion.</h5>
            </div>
            <div class="col-md-4 text-center">
                <h3>Customer Support</h3>
                <br>
                <i class="fas fa-phone fa-5x"></i>
                <br><br>
                <h5>Customer support available whenever you need it. We will be sure to resolve any issues.</h5>
            </div>
        </div>
    </section>
</body>
</html>
