package com.example.techtitans

import java.text.DecimalFormat

fun formatAmount(amount: Float): String {
    return AmountDecimalFormat.format(amount)
}

private val AccountDecimalFormat = DecimalFormat("####")
private val AmountDecimalFormat = DecimalFormat("#,###.##")

fun <E> List<E>.extractProportions(selector: (E) -> Float): List<Float> {
    val total = this.sumOf { selector(it).toDouble() }
    return this.map { (selector(it) / total).toFloat() }
}
