package adrianoqueiroz.dev.quotify.view

import adrianoqueiroz.dev.quotify.R
import adrianoqueiroz.dev.quotify.view.composables.BottomBarActions
import adrianoqueiroz.dev.quotify.view.composables.DialogCategories
import adrianoqueiroz.dev.quotify.view.composables.PhraseMaster
import adrianoqueiroz.dev.quotify.viewmodel.HomeScreenViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
   val context = LocalContext.current.applicationContext
   val systemUiController = rememberSystemUiController()

   systemUiController.setStatusBarColor(
      color = Color.Black.copy(alpha = 0.9f),
      darkIcons = false,
   )

   val viewModel = viewModel<HomeScreenViewModel>(
      factory = object : ViewModelProvider.Factory {
         override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return HomeScreenViewModel(context = context) as T
         }
      }
   )

   val backgroundImage by viewModel.backgroundImage.collectAsState()
   val openDialog = remember { mutableStateOf(false) }
   val phraseResponse by viewModel.phraseResponse.collectAsState()
   val iconCopy by viewModel.iconCopy.collectAsState()

   Scaffold(
      containerColor = Color.Transparent,
      topBar = {
         TopAppBar(
            modifier = Modifier
               .height(80.dp)
               .padding(top = 12.dp),
            colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.Transparent),
            title = {
               Image(
                  painter = painterResource(id = R.drawable.logo),
                  contentDescription = null,
                  modifier = Modifier
                     .height(160.dp)
                     .width(200.dp)
               )
            },
            actions = {
               IconButton(onClick = { viewModel.copyToClipboard() }) {
                  Icon(
                     imageVector = iconCopy,
                     contentDescription = null,
                     tint = MaterialTheme.colorScheme.onPrimary
                  )
               }
            }
         )
      },
      bottomBar = {
         BottomBarActions(
            openDialog = openDialog,
            onReload = { viewModel.loadPhrase() },
            viewModel = viewModel
         )
      }
   ) {
      Image(
         modifier = Modifier.fillMaxSize(),
         painter = painterResource(backgroundImage),
         contentDescription = null,
         contentScale = ContentScale.FillHeight,
      )
      Box(
         modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black.copy(alpha = 0.8f))
      )
      LazyColumn(
         modifier = Modifier
            .padding(it)
            .padding(
               top = 16.dp,
               start = 24.dp,
               end = 24.dp,
               bottom = 24.dp
            )
      ) {
         if (phraseResponse.data.content != null) {
            item {
               Text(
                  text = phraseResponse.data.content!!,
                  style = MaterialTheme.typography.titleMedium,
                  color = MaterialTheme.colorScheme.onPrimary,
                  modifier = Modifier.padding(bottom = 16.dp)
               )

               PhraseMaster(phraseMaster = phraseResponse.data.phraseMaster!!)
            }
         }

         if (phraseResponse.message != "") {
            item {
               Text(
                  text = phraseResponse.message,
                  style = MaterialTheme.typography.bodyLarge,
                  color = MaterialTheme.colorScheme.onPrimary,
                  modifier = Modifier.padding(bottom = 16.dp)
               )
            }
         }
      }

      if (openDialog.value) {
         DialogCategories(
            openDialog = openDialog,
            viewModel = viewModel,
         )
      }
   }
}
