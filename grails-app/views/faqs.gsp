<!doctype html>
<html>
<head>
    <title>FAQs</title>
    <meta name="layout" content="main">
    <script src="/assets/faqs.js"></script>
</head>
<body>
    <div class="text-center container">
        <div class="container">
            <h1 class="text-secondary">How can we help you?</h1>
            <br><br>
            <input type="text" id="userQuestion" name="userQuestion" />
            <button onclick="faqReply($('#userQuestion').val());" type="button" class="btn btn-info">Find my answer</button>
            <br><br>
            <h3 class="hidden" id="answer"></h3>
        </div>
    </div>
</body>
</html>
