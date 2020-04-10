package domain.cart

import domain.calculators.DiscountCalculator
import domain.types.Amount
import domain.types.Customer

class ShoppingCart(val customer: Customer, val discountCalculator: DiscountCalculator) {
    fun billAmount(purchaseAmount: Amount): Amount {
        return purchaseAmount
    }
}
