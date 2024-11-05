package com.miftah.cashchill.data

import android.os.Build
import androidx.annotation.RequiresApi
import com.miftah.cashchill.utilities.generateRandomBoolean
import com.miftah.cashchill.utilities.generateRandomInt
import com.miftah.cashchill.utilities.generateRandomString
import com.miftah.cashchill.utilities.getCurrentDate
import java.util.Locale

fun generate_dummy(many : Int) : List<CashChillData> {
    val data = mutableListOf<CashChillData>()
    for (i in 1..many) {
        data.add(
            CashChillData(
                date = getCurrentDate(),
                description = generateRandomString(10),
                money = generateRandomInt(1000, 10000),
                isAdding = generateRandomBoolean()
            )
        )
    }
    return data
}