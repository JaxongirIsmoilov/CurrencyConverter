package uz.gita.jaxongir.currencyconverter.presenter.main

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.jaxongir.currencyconverter.R
import uz.gita.jaxongir.currencyconverter.presenter.components.ItemView
import uz.gita.jaxongir.currencyconverter.ui.theme.CurrencyConverterTheme

class MainScreen : AndroidScreen() {
    @RequiresApi(Build.VERSION_CODES.Q)
    @Composable
    override fun Content() {
        val viewModel: MainContract.ViewModel = getViewModel<MainViewModel>()

        CurrencyConverterTheme {
            MainContent(
                viewModel.uiState.collectAsState().value,
                viewModel::eventDispatcher
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun MainContent(
    uiState: MainContract.UIState = MainContract.UIState(),
    onEventDispatcher: (MainContract.Intent) -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        LazyColumn {
            item {
                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Barcha valyuta kurslari", style = TextStyle(
                        fontSize = 24.sp,
                        fontFamily = FontFamily(Font(R.font.roboto_bold)),
                        fontWeight = FontWeight(700),
                        color = Color(0xFF161513)
                    )
                )
                Spacer(modifier = Modifier.height(28.dp))
            }
            items(uiState.currencyList) {

                ItemView(it, uiState.firstClick.Ccy == it.Ccy) { data ->
                    onEventDispatcher.invoke(
                        MainContract.Intent.Click(data)
                    )

                }
            }

        }
    }
}

@RequiresApi(Build.VERSION_CODES.Q)
@Preview(showBackground = true)
@Composable
fun MainContentPrew() {

    CurrencyConverterTheme {
        MainContent()
    }
}