package domain.cart

import domain.slabs.DiscountSlab
import domain.types.Amount
import domain.types.Customer

class ShoppingCart(val customer: Customer, val discountSlabs: List<DiscountSlab>) {
    fun billAmount(purchaseAmount: Amount): Amount {
        return purchaseAmount
    }
}
