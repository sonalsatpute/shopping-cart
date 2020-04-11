package domain.types

import java.math.BigDecimal

data class Amount(val value: BigDecimal) : Comparable<Amount> {
    companion object {
        fun zero() = Amount(BigDecimal(0.00))
    }


    override fun compareTo(other: Amount): Int = this.value.compareTo(other.value)

    override fun equals(other: Any?): Boolean {
        if (other == null) return false

        return this.compareTo(other as Amount) == 0
    }

    override fun hashCode(): Int {
        return value.multiply(BigDecimal("100")).intValueExact()
    }
}
