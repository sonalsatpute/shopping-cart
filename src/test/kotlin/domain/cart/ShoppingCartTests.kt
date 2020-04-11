package domain.cart

import domain.slabs.DiscountSlab
import domain.types.Amount
import domain.types.Customer
import domain.types.CustomerType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.math.BigDecimal

class ShoppingCartTests {
    @Test
    fun `shopping cart takes customer and list of discount slabs`() {
        val customer = Customer(CustomerType.Regular)
        val discountSlabs = listOf<DiscountSlab>()
        val shoppingCart = ShoppingCart(customer, discountSlabs)

        assertEquals(customer, shoppingCart.customer)
        assertEquals(discountSlabs, shoppingCart.discountSlabs)
    }

    @Test
    fun `shopping cart should calculates bill amount`() {
        val customer = Customer(CustomerType.Regular)
        val discountSlabs = listOf<DiscountSlab>()
        val shoppingCart = ShoppingCart(customer, discountSlabs)
        val purchaseAmount = Amount(BigDecimal(100))

        val billAmount = shoppingCart.billAmount(purchaseAmount)

        assertEquals(purchaseAmount, billAmount)
    }
}

