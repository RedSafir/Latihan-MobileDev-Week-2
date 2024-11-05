package com.miftah.cashchill

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.miftah.cashchill.ui.AddingPage
import com.miftah.cashchill.ui.HomePage
import com.miftah.cashchill.ui.theme.CashChillTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CashChillTheme {
                CashChillApplication()
            }
        }
    }
}

@Composable
fun CashChillApplication(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "HomePage") {
        composable(route = "HomePage"){
            HomePage(
                modifier = Modifier,
                toAdding = {
                    navController.navigate("AddingPage")
                }
            )
        }
        composable(route = "AddingPage") {
            AddingPage(
                 navigate = {
                     navController.navigate("HomePage")
                 }
            )
        }
    }
}