package adrianoqueiroz.dev.quotify

import adrianoqueiroz.dev.quotify.data.constants.Routes
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import adrianoqueiroz.dev.quotify.ui.theme.QuotifyTheme
import adrianoqueiroz.dev.quotify.view.HomeScreen
import adrianoqueiroz.dev.quotify.view.SplashScreen
import adrianoqueiroz.dev.quotify.viewmodel.HomeScreenViewModel
import android.content.pm.ActivityInfo
import android.view.WindowManager
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)

      requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

      setContent {
         QuotifyTheme {
            val navController = rememberNavController()

            NavHost(
               navController = navController,
               startDestination = Routes.SPLASH
            ) {
               composable(route = Routes.SPLASH) {
                  SplashScreen(navController = navController)
               }
               composable(route = Routes.HOME) {
                  HomeScreen()
               }
            }
         }
      }
   }
}
