package com.miftah.cashchill.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.miftah.cashchill.ui.theme.Green
import com.miftah.cashchill.ui.theme.Red

@Composable
fun TextMoney(modifier: Modifier = Modifier, money: Int, positive: Boolean) {
    if (positive) {
        Text(
            modifier = modifier,
            text = "+Rp" + money,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.SemiBold,
                color = Green,
                fontSize = 16.sp
            )
        )
    } else {
        Text(
            modifier = modifier,
            text = "-Rp" + money,
            style = MaterialTheme.typography.titleMedium.copy(
                fontWeight = FontWeight.SemiBold,
                color = Red,
                fontSize = 16.sp
            )
        )
    }
}