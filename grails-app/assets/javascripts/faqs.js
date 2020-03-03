function faqReply(userQuestion){
    var URL="/faq/faqReply";

    $.ajax({
       url: URL,
       data: {userQuestion: userQuestion},
       success: function(resp){
            $('#answer').removeClass('hidden');
            $('#answer').html(resp);
       }
    });
}