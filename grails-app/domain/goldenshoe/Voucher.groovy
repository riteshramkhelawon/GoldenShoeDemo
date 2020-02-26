package goldenshoe

class Voucher {
    String voucherCode
    double discount
    Date expiry

    static constraints = {
        voucherCode nullable: false
        discount nullable: false
        expiry nullable: false
    }
}
