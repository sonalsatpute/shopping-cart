package domain.slabs

import domain.types.Amount
import domain.types.CustomerType

interface DiscountSlab {
    fun calculate(customerType: CustomerType, purchaseAmount: Amount) : Amount
}

