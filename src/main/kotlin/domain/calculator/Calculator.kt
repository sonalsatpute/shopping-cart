package domain.calculator

import domain.types.Amount

interface Calculator {
    fun calculate(amount: Amount) : Amount
}