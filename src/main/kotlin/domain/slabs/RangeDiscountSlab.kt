package domain.slabs

import domain.calculator.Calculator
import domain.types.Amount
import domain.types.CustomerType
import java.math.BigDecimal

class RangeDiscountSlab(val customerType: CustomerType, val startWithAmount: Amount, val endBeforeAmount: Amount, val calculator: Calculator) : DiscountSlab {

    override fun discount(customerType: CustomerType, purchaseAmount: Amount): Amount {
        if (startWithAmount > purchaseAmount) return Amount(BigDecimal(0.00))

        return Amount(BigDecimal(-1))
    }
}