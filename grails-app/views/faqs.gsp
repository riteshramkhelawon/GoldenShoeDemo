<!doctype html>
<html>
<head>
    <title>FAQs</title>
    <meta name="layout" content="main">
</head>
<body>
<script>
        function faqReply(userQuestion){
            var URL="${createLink(controller:'faq', action:'faqReply')}";
            console.log("ajax call - faq");
            $.ajax({
                   url: URL,
                   data: {userQuestion: userQuestion},
                   success: function(resp){
                        console.log(resp);
                        $('#answer').removeClass('hidden');
                        $('#answer').html(resp);
               }
            });
        }
    </script>

<div class="text-center container">
    <div class="container">
        <h1 class="text-secondary">How can we help you?</h1>
<!--        <h3>Enter your order number below</h3>-->
<!--        <small>Please make sure you enter the correct order number (case sensitive)</small>-->
        <br><br>
        <input type="text" id="userQuestion" name="userQuestion" />
        <button onclick="faqReply($('#userQuestion').val());" type="button" class="btn btn-info">Find my answer</button>
        <br><br>
        <h3 class="hidden" id="answer"></h3>
    </div>

</div>
</body>
</html>
