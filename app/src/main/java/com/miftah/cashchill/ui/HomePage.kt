package com.miftah.cashchill.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miftah.cashchill.R
import com.miftah.cashchill.component.CardHome
import com.miftah.cashchill.component.CardHomeData
import com.miftah.cashchill.component.TextMoney
import com.miftah.cashchill.data.CashChillData
import com.miftah.cashchill.data.dataCashChill
import com.miftah.cashchill.data.generate_dummy
import com.miftah.cashchill.ui.theme.CashChillTheme
import com.miftah.cashchill.ui.theme.Gray80
import com.miftah.cashchill.ui.theme.Green
import com.miftah.cashchill.ui.theme.White60

@Composable
fun HomePage(modifier: Modifier = Modifier, toAdding: () -> Unit) {
    val dummyData = dataCashChill
    var money by remember {
        mutableIntStateOf(0)
    }
    val moneyPositive by remember {
        derivedStateOf {
            when {
                (money < 0) -> false
                else -> true
            }
        }
    }
    dummyData.forEach { data ->
        if (data.isAdding) {
            money += data.money
        } else {
            money -= data.money
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        CashChillHeader(user = "Miftah")
        Spacer(modifier = Modifier.height(16.dp))
        CashChillNavigator( toAdding = toAdding)
        Spacer(modifier = Modifier.height(16.dp))
        CashChillCountMoney(money = money, moneyPositive = moneyPositive)
        Spacer(modifier = Modifier.height(16.dp))
        CashChillRecentActivity(recentData = dummyData)
    }
}

@Composable
fun CashChillHeader(modifier: Modifier = Modifier, user : String) {
    Column(

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Hello, Miftah",
                style = MaterialTheme.typography.labelLarge.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = White60
                )
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Max)
        ) {
            Image(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                painter = painterResource(id = R.drawable.card),
                contentDescription = null,
            )
        }
    }
}

@Composable
fun CashChillNavigator(modifier: Modifier = Modifier, toAdding : () -> Unit) {
    Row(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .weight(1f)
                .background(Gray80)
                .padding(vertical = 16.dp)
                .clickable {
                    toAdding()
                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier,
                painter = painterResource(id = R.drawable.ic_deposit),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Deposit",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Normal,
                    color = White60,
                    fontSize = 16.sp,
                ),
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .weight(1f)
                .background(Gray80)
                .padding(vertical = 16.dp)
                .clickable {

                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_withdraw),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Spend",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Normal,
                    color = White60,
                    fontSize = 16.sp
                ),
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .weight(1f)
                .background(Gray80)
                .padding(vertical = 16.dp)
                .clickable {

                },
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_history),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "History",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Normal,
                    color = White60,
                    fontSize = 16.sp
                ),
            )
        }
    }
}

@Composable
fun CashChillCountMoney(modifier: Modifier = Modifier, money  : Int, moneyPositive : Boolean) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .background(Gray80)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.ic_money),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Stored",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Normal,
                    color = White60,
                    fontSize = 16.sp
                )
            )
        }
        TextMoney(money = money, positive = moneyPositive)
    }
}

@Composable
fun CashChillRecentActivity(modifier: Modifier = Modifier, recentData : List<CashChillData>) {
    LazyColumn(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxSize()
            .background(Gray80)
            .padding(16.dp)
            .navigationBarsPadding()
    ) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Recent Activity",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Normal,
                        color = White60,
                        fontSize = 16.sp
                    )
                )
                Text(
                    text = "Money",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Normal,
                        color = White60,
                        fontSize = 16.sp
                    )
                )
            }
        }
        items(recentData) { data ->
            Spacer(modifier = Modifier.height(8.dp))
            CardHome(
                cardHomeData = CardHomeData(
                    date = data.date,
                    money = data.money,
                    description = data.description,
                    isAddingMoney = data.isAdding
                )
            )
        }
    }
}

//@Preview
@Composable
private fun CashChillHeaderPreview() {
    CashChillTheme {
        CashChillHeader(user = "Miftah")
    }
}

//@Preview
@Composable
private fun CashChillNavigatorPreview() {
    CashChillTheme {
        CashChillNavigator(
            toAdding = {

            }
        )
    }
}

//@Preview
@Composable
fun CashChillMoneyPreview(modifier: Modifier = Modifier) {
    CashChillTheme {
        CashChillCountMoney(money = 10000, moneyPositive = true)
    }
}

@Preview
@Composable
private fun CashChillRecentActivityPreview() {
    val dummyData = generate_dummy(6)
    CashChillTheme {
        CashChillRecentActivity(recentData = dummyData)
    }
}

//@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    CashChillTheme {

    }
}
