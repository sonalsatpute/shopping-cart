package domain.calculator

import domain.types.Amount
import domain.types.Percentage
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class DiscountCalculatorTests {
    @Test
    fun `calculate discount by percentage`() {
        val discountPercentage = Percentage(BigDecimal(0.10))
        val calculator: Calculator = DiscountCalculator(discountPercentage)
        val purchaseAmount = Amount(BigDecimal(1000))
        val discountedAmount = calculator.calculate(purchaseAmount)
        val expectedAmount = Amount(BigDecimal(100.00))

        assertEquals(expectedAmount, discountedAmount)
    }
}