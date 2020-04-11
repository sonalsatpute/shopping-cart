package domain.slabs

import domain.types.Amount
import domain.types.CustomerType

interface DiscountSlab {
    fun discount(customerType: CustomerType, purchaseAmount: Amount) : Amount
}

