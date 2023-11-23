package adrianoqueiroz.dev.quotify.view.composables

import adrianoqueiroz.dev.quotify.viewmodel.HomeScreenViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun BottomBarActions(
   openDialog: MutableState<Boolean>,
   onReload: () -> Unit = {},
   viewModel: HomeScreenViewModel
) {
   val selectedCategory by viewModel.selectedCategory.collectAsState()

   Box() {
      Row(
         verticalAlignment = Alignment.CenterVertically,
         modifier = Modifier
            .height(100.dp)
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .fillMaxWidth()
            .background(color = Color.Black.copy(alpha = 0.3f))
      ) {
         Spacer(modifier = Modifier.width(16.dp))
         IconButton(onClick = onReload) {
            Icon(
               imageVector = Icons.Filled.Refresh,
               contentDescription = null,
               tint = MaterialTheme.colorScheme.onPrimary
            )
         }
         Spacer(modifier = Modifier.width(16.dp))
         Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
               .clickable { openDialog.value = true }
               .border(
                  width = 1.dp,
                  color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.3f),
                  shape = RoundedCornerShape(16.dp)
               )
               .height(64.dp)
               .weight(1f)
               .padding(16.dp)
         ) {
            Text(
               text = selectedCategory.name,
               color = MaterialTheme.colorScheme.onPrimary,
               style = MaterialTheme.typography.labelMedium.copy(
                  fontWeight = FontWeight.SemiBold
               )
            )
            Icon(
               imageVector = Icons.Filled.ExpandMore,
               contentDescription = null,
               tint = MaterialTheme.colorScheme.onPrimary
            )
         }
         Spacer(modifier = Modifier.width(16.dp))
      }
   }
}
























