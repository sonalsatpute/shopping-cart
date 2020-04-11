package domain.slabs

import domain.calculator.Calculator
import domain.types.Amount
import domain.types.CustomerType
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class RangeDiscountSlabTests {

    @Test
    fun `when start with amount is greater than purchase amount, discount should be zero` () {
        val startWithAmount = Amount(BigDecimal(5000.00))
        val endBeforeAmount = Amount(BigDecimal(10000.00))
        val purchaseAmount = Amount(BigDecimal(101.00))
        val calculator = mockk<Calculator>()
        val discountSlab = RangeDiscountSlab(CustomerType.Regular, startWithAmount, endBeforeAmount, calculator)

        val discount = discountSlab.discount(CustomerType.Regular, purchaseAmount)

        assertEquals(Amount.zero(), discount)
    }
}