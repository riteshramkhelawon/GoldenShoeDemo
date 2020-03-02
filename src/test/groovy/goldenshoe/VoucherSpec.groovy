package goldenshoe

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification
import spock.mock.MockFactory

class VoucherSpec extends Specification implements DomainUnitTest<Voucher> {
    void "Test validation of a complete voucher"() {
        given: "a complete new voucher"

        def voucherCode = "abc012"
        def discount = 0.5
        def expiry = new Date()

        def voucher = new Voucher(voucherCode: voucherCode, discount: discount, expiry: expiry)

        expect:"validation passes"
        true == voucher.validate()
    }

    void "Test validation of an incomplete voucher with no valid voucherCode"() {
        given: "no valid voucherCode"

        def voucherCode = null
        def discount = 0.5
        def expiry = new Date()

        def voucher = new Voucher(voucherCode: voucherCode, discount: discount, expiry: expiry)

        expect:"validation fails"
        false == voucher.validate()
    }

    void "Test validation of an incomplete voucher with no valid discount value"() {
        given: "no valid voucherCode"

        def voucherCode = "abc123"
        def discount = null
        def expiry = new Date()

        def voucher = new Voucher(voucherCode: voucherCode, discount: discount, expiry: expiry)

        expect:"validation fails"
        false == voucher.validate()
    }

    void "Test validation of an incomplete voucher with no valid expiry"() {
        given: "no valid expiry"

        def voucherCode = "abc123"
        def discount = 0.5
        def expiry = null

        def voucher = new Voucher(voucherCode: voucherCode, discount: discount, expiry: expiry)

        expect:"validation fails"
        false == voucher.validate()
    }
}
