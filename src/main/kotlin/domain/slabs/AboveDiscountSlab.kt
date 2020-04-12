package domain.slabs

import domain.calculator.Calculator
import domain.types.Amount
import domain.types.CustomerType
import java.math.BigDecimal

class AboveDiscountSlab(private val customerType: CustomerType, private val startAmount: Amount,
                        private val calculator: Calculator) : DiscountSlab {

    override fun discount(customerType: CustomerType, purchaseAmount: Amount): Amount {
        if (this.customerType != customerType) return Amount.zero()
        if (purchaseAmount < startAmount) return Amount.zero()

        return Amount(BigDecimal(-1))
    }

}
