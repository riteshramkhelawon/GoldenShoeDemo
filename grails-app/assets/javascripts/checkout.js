function applyVoucherCode(voucherCode, totalPrice){
		var URL = "/cart/calculateDiscountedTotal"
    $.ajax({
           url: URL,
           data: {voucherCode: voucherCode, totalPrice: totalPrice},
           success: function(resp){
                if(resp.valid == true){
                    $('#validVoucherCode').removeClass('hidden');
                    $('#invalidVoucherCode').addClass('hidden');
                    $('#discountedTotalTableRow').removeClass('hidden');
                    $('#discountedTotal').html(resp.discountedTotal.toFixed(2));
                    $('#discountedTotalHidden').val(resp.discountedTotal.toFixed(2));
                    $('#applyCodeBtn').prop('disabled', true);
                    $('#wasVoucherApplied').val(true);
                } else {
                    $('#invalidVoucherCode').removeClass('hidden');
                    $('#validVoucherCode').addClass('hidden');
                    $('#discountedTotalHidden').val(resp.discountedTotal.toFixed(2));
                }
       }
    });
}
