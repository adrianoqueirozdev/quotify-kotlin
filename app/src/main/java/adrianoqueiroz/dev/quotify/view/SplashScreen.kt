package adrianoqueiroz.dev.quotify.view

import adrianoqueiroz.dev.quotify.R
import adrianoqueiroz.dev.quotify.data.constants.Routes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.shrinkOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.delay

private const val DELAY_START_ANIMATION = 200L
private const val DELAY_DURATION_ANIMATION = 3000L
private const val DELAY_END_ANIMATION = 600L

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SplashScreen(navController: NavController) {
   var visible by remember { mutableStateOf(false) }

   LaunchedEffect(Unit) {
      delay(timeMillis = DELAY_START_ANIMATION)
      visible = true
      delay(timeMillis = DELAY_DURATION_ANIMATION)
      visible = false
      delay(timeMillis = DELAY_END_ANIMATION)

      navController.navigate(route = Routes.HOME) {
         popUpTo(route = Routes.SPLASH) {
            inclusive = true
         }
      }
   }

   Scaffold(
      containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
   ) {
      Column(
         verticalArrangement = Arrangement.Center,
         horizontalAlignment = Alignment.CenterHorizontally,
         modifier = Modifier
            .padding(it)
            .fillMaxSize()
      ) {
         AnimatedVisibility(
            visible,
            enter = expandIn(
               animationSpec = tween(durationMillis = 700, easing = LinearOutSlowInEasing),
               expandFrom = Alignment.BottomStart
            ) {
               IntSize(50, 50)
            },
            exit = shrinkOut(
               tween(durationMillis = 400, easing = FastOutSlowInEasing),
               shrinkTowards = Alignment.CenterStart
            ) { fullSize ->
               IntSize(fullSize.width / 10, fullSize.height / 5)
            }
         ) {
            Image(
               painter = painterResource(id = R.drawable.logo),
               contentDescription = null,
               modifier = Modifier
                  .height(150.dp)
                  .width(230.dp)
            )
         }
      }
   }
}

@Preview
@Composable
fun SplashScreenPreview() {
   SplashScreen(
      navController = NavController(LocalContext.current.applicationContext)
   )
}


