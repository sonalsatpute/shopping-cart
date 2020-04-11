package domain.slabs

import domain.calculator.Calculator
import domain.types.Amount
import domain.types.CustomerType
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal

internal class RangeDiscountSlabTests {

    @Test
    fun `when purchase amount is less than slab rage, discount should be zero` () {
        val startAfterAmount = Amount(BigDecimal(5000.00))
        val endBeforeAmount = Amount(BigDecimal(10000.00))
        val purchaseAmount = Amount(BigDecimal(101.00))
        val calculator = mockk<Calculator>()
        val discountSlab = RangeDiscountSlab(CustomerType.Regular, startAfterAmount, endBeforeAmount, calculator)

        val discount = discountSlab.discount(CustomerType.Regular, purchaseAmount)

        assertEquals(Amount.zero(), discount)
    }

    @Test
    fun `when purchase amount is greater than slab range, discount should be zero`() {
        val startAfterAmount = Amount(BigDecimal(5000.00))
        val endBeforeAmount = Amount(BigDecimal(10000.00))
        val purchaseAmount = Amount(BigDecimal(15000.00))
        val calculator = mockk<Calculator>()
        val discountSlab = RangeDiscountSlab(CustomerType.Regular, startAfterAmount, endBeforeAmount, calculator)

        val discount = discountSlab.discount(CustomerType.Regular, purchaseAmount)

        assertEquals(Amount.zero(), discount)
    }

    @Test
    fun `when purchase amount is within slab range, 10% discount should be calculated` () {
        val startWithAmount = Amount(BigDecimal(5000.00))
        val endBeforeAmount = Amount(BigDecimal(10000.00))
        val purchaseAmount = Amount(BigDecimal(10000.00))
        val expectedDiscountAmount = Amount(BigDecimal(500.00))

        val calculator = mockk<Calculator>()
        every { calculator.calculate(Amount(BigDecimal(5000))) } returns expectedDiscountAmount

        val discountSlab = RangeDiscountSlab(CustomerType.Regular, startWithAmount, endBeforeAmount, calculator)

        val discount = discountSlab.discount(CustomerType.Regular, purchaseAmount)

        assertEquals(expectedDiscountAmount, discount)
    }
}