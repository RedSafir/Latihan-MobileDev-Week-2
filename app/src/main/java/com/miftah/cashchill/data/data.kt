package com.miftah.cashchill.data

import com.miftah.cashchill.utilities.getCurrentDate

data class CashChillData(
    val description: String,
    val money: Int,
    val isAdding: Boolean = true,
    val date: String = getCurrentDate()
)

val dataCashChill = mutableListOf<CashChillData>()