package domain.cart

import domain.calculators.DiscountCalculator
import domain.types.Amount
import domain.types.Customer
import domain.types.CustomerType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class ShoppingCartTests {
    @Test
    fun `shopping cart takes Customer, DiscountCalculator`() {
        val customer = Customer(CustomerType.Regular)
        val discountCalculator = DiscountCalculator()
        val shoppingCart = ShoppingCart(customer, discountCalculator)

        assertEquals(customer, shoppingCart.customer)
        assertEquals(discountCalculator, shoppingCart.discountCalculator)
    }

    @Test
    fun `shopping cart calculates bill Amount on Purchase Amount`() {
        val customer = Customer(CustomerType.Regular)
        val discountCalculator = DiscountCalculator()
        val shoppingCart = ShoppingCart(customer, discountCalculator)
        val purchaseAmount = Amount(BigDecimal(100))

        val billAmount = shoppingCart.billAmount(purchaseAmount)

        assertEquals(purchaseAmount, billAmount)
    }
}