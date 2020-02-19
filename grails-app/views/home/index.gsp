<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Golden Shoe</title>
</head>
<body>

<div id="content" role="main">
    <section class="text-primary row m-0" style="max-width: 100%;">
        <div class="container">


        </div>

        <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img height="auto" width="60%" src="/assets/shoes/converse.jpg" class="img-fluid rounded mx-auto d-block" alt="Responsive image" />
                    <div class="carousel-caption d-none d-md-block">
                        <h5>Converse</h5>
                        <p>New amazing line of Converse shoes</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img height="auto" width="60%" src="/assets/shoes/beige-shoes.jpg" class="img-fluid rounded mx-auto d-block" alt="Responsive image" />
                    <div class="carousel-caption d-none d-md-block">
                        <h5>Beige shoes</h5>
                        <p>New amazing line of beige coloured shoes</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img height="auto" width="60%" src="/assets/shoes/heels.jpg" class="img-fluid rounded mx-auto d-block" alt="Responsive image" />
                    <div class="carousel-caption d-none d-md-block">
                        <h5>Heeled shoes</h5>
                        <p>New line of high heel shoes</p>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                <span aria-hidden="true"><i class="fas fa-angle-left fa-5x text-primary"></i></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                <span aria-hidden="true"><i class="fas fa-angle-right fa-5x text-primary"></i></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </section>

    <section class="container">
        <h2 class="text-center">Top Products</h2>

        <g:each var="product" in="${products}">
            <div>
                <p>${product.productName}</p>
                <small>${product.description}</small>
                <br><br>
                <p>£<span><g:formatNumber number="${product.price}" type="currency" currencySymbol=""/></span></p>
                <form action="/product/index" method="get">
                    <input type="hidden" name="productName" value="${product.productName}">
                    <button type="submit">View Product</button>
                </form>
            </div>
        </g:each>

    </section>

</div>

</body>
</html>
