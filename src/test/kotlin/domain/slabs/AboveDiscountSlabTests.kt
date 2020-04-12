package domain.slabs

import domain.calculator.Calculator
import domain.types.Amount
import domain.types.CustomerType
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class AboveDiscountSlabTests {

    @Test
    fun `when customer type not match, discount should be zero`() {
        val startAfterAmount = Amount(BigDecimal(5000.00))
        val purchaseAmount = Amount(BigDecimal(6000.00))

        val calculator = mockk<Calculator>()
        val discountSlab = AboveDiscountSlab(CustomerType.Regular, startAfterAmount, calculator)

        val discount = discountSlab.discount(CustomerType.Unknown, purchaseAmount)

        Assertions.assertEquals(Amount.zero(), discount)
    }

    @Test
    fun `when purchase amount is less than start amount, discount should be zero`() {
        val startAmount = Amount(BigDecimal(5000.00))
        val purchaseAmount = Amount(BigDecimal(4000.00))

        val calculator = mockk<Calculator>()
        val discountSlab = AboveDiscountSlab(CustomerType.Regular, startAmount, calculator)

        val discount = discountSlab.discount(CustomerType.Regular, purchaseAmount)

        Assertions.assertEquals(Amount.zero(), discount)
    }
}