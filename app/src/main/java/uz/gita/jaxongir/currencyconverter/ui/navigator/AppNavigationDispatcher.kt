package uz.gita.jaxongir.currencyconverter.ui.navigator

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppNavigationDispatcher @Inject constructor(): AppNavigator, AppNavigationHandler {
    override val navigationFlow = MutableSharedFlow<NavigationArgs>()

    suspend fun navigate(navigationArgs: NavigationArgs){
        navigationFlow.emit(navigationArgs)
    }
    override suspend fun navigateWithSave(myScreen: MyScreen) = navigate{
        push(myScreen)
    }

    override suspend fun navigateWithoutSave(myScreen: MyScreen) = navigate{
        replace(myScreen)
    }

    override suspend fun back() =navigate{
        pop()
    }

}