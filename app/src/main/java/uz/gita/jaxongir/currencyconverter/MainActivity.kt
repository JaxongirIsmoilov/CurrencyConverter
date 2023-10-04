package uz.gita.jaxongir.currencyconverter

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.jaxongir.currencyconverter.presenter.main.MainScreen
import uz.gita.jaxongir.currencyconverter.ui.navigator.AppNavigationHandler
import uz.gita.jaxongir.currencyconverter.ui.theme.CurrencyConverterTheme
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var appNavigationHandler: AppNavigationHandler
    @SuppressLint("CoroutineCreationDuringComposition", "FlowOperatorInvokedInComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CurrencyConverterTheme {
               Navigator(MainScreen()){ navigator ->
                   appNavigationHandler.navigationFlow.onEach {
                       it.invoke(navigator)
                   }.launchIn(lifecycleScope)
                   CurrentScreen()
               }
            }
        }
    }
}

