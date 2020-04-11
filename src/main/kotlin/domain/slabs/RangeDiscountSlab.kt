package domain.slabs

import domain.calculator.Calculator
import domain.types.Amount
import domain.types.CustomerType
import java.math.BigDecimal

class RangeDiscountSlab(private val customerType: CustomerType, private val startAfterAmount: Amount,
                        private val endsOnAmount: Amount, private val calculator: Calculator) : DiscountSlab {

    override fun discount(customerType: CustomerType, purchaseAmount: Amount): Amount {
        if (this.customerType != customerType) return Amount.zero()
        if (purchaseAmount < startAfterAmount) return Amount.zero()
        if (purchaseAmount > endsOnAmount ) return calculator.calculate(endsOnAmount - startAfterAmount)

        return calculator.calculate(purchaseAmount - startAfterAmount)
    }
}