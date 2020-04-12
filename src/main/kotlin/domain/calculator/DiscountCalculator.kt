package domain.calculator

import domain.types.Amount
import domain.types.Percentage

class DiscountCalculator(private val percentage: Percentage) : Calculator {
    override fun calculate(amount: Amount) : Amount {
        return amount * percentage
    }
}
