package com.miftah.cashchill.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.miftah.cashchill.data.CashChillData
import com.miftah.cashchill.data.dataCashChill
import com.miftah.cashchill.ui.theme.Black90
import com.miftah.cashchill.ui.theme.CashChillTheme
import com.miftah.cashchill.ui.theme.Gray80
import com.miftah.cashchill.ui.theme.White60

@Composable
fun AddingPage(
    modifier: Modifier = Modifier,
    navigate: () -> Unit
) {
    val descriptionState = remember {
        mutableStateOf("")
    }
    val moneyState = remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        containerColor = Black90,
        bottomBar = {
            Surface(
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .navigationBarsPadding() // padding for navigation bar
                    .imePadding() // padding for when IME appears
                    .clickable {
                        dataCashChill.add(
                            CashChillData(
                                money = moneyState.value,
                                description = descriptionState.value
                            )
                        )
                        navigate()
                    }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(White60)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "DEPOSIT",
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Gray80
                        )
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    modifier = Modifier,
                    onClick = {
                        navigate()
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "DEPOSIT MONEY",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelLarge.copy(
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = White60
                    )
                )
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Description",
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = White60
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = descriptionState.value,
                        onValueChange = {
                            descriptionState.value = it
                        },
                        textStyle = MaterialTheme.typography.titleMedium.copy(
                            color = White60
                        )
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "Money",
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = White60
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        modifier = Modifier.fillMaxWidth(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        value = moneyState.value.toString(),
                        onValueChange = {
                            moneyState.value = it.toInt()
                        },
                        textStyle = MaterialTheme.typography.titleMedium.copy(
                            color = White60
                        )
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview
@Composable
private fun AddingScreenPreview() {
    CashChillTheme {
        AddingPage(
            navigate = {}
        )
    }
}

@Preview
@Composable
private fun Test() {
    var nama = remember {
        mutableStateOf("")
    }
    Column {
        TextField(
            value = nama.value,
            onValueChange = { newName ->
                nama.value = newName
            },
            leadingIcon = {

            }
        )
    }
}