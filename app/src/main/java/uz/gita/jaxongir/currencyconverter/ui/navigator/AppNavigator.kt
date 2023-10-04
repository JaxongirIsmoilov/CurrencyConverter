package uz.gita.jaxongir.currencyconverter.ui.navigator

import cafe.adriel.voyager.androidx.AndroidScreen

typealias MyScreen = AndroidScreen
interface AppNavigator {
    suspend fun navigateWithSave(myScreen: MyScreen)
    suspend fun navigateWithoutSave(myScreen: MyScreen)
    suspend fun back()
}