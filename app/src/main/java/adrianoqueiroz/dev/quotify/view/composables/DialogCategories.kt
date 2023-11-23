package adrianoqueiroz.dev.quotify.view.composables

import adrianoqueiroz.dev.quotify.data.model.CategoryModel
import adrianoqueiroz.dev.quotify.ui.theme.seed
import adrianoqueiroz.dev.quotify.viewmodel.HomeScreenViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp

@Composable
fun DialogCategories(
   openDialog: MutableState<Boolean>,
   viewModel: HomeScreenViewModel,
) {
   val categories by viewModel.categoryResponse.collectAsState()
   val selectedCategory by viewModel.selectedCategory.collectAsState()

   AlertDialog(
      containerColor = seed,
      onDismissRequest = { openDialog.value = false },
      confirmButton = {
         if (categories.message != "") {
            TextButton(onClick = { openDialog.value = false }) {
               Text(
                  text = "OK",
                  style = MaterialTheme.typography.labelMedium,
                  color = MaterialTheme.colorScheme.onPrimary,
               )
            }
         }
      },
      title = {
         Text(
            text = "Categorias",
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(bottom = 4.dp)
         )
      },
      text = {
         Column(Modifier.selectableGroup()) {
            if (categories.message != "") {
               Text(
                  text = categories.message,
                  style = MaterialTheme.typography.titleSmall,
                  color = MaterialTheme.colorScheme.onPrimary,
                  modifier = Modifier.padding(bottom = 16.dp)
               )
            }
            categories.data.forEach { category ->
               RadioButtonCategory(
                  selectedCategory = selectedCategory,
                  category = category,
                  viewModel = viewModel,
                  openDialog = openDialog
               )
            }
         }
      }
   )
}

@Composable
private fun RadioButtonCategory(
   selectedCategory: CategoryModel,
   category: CategoryModel,
   viewModel: HomeScreenViewModel,
   openDialog: MutableState<Boolean>,
) {
   Row(
      Modifier
         .fillMaxWidth()
         .height(48.dp)
         .selectable(
            selected = selectedCategory == category,
            onClick = {
               openDialog.value = false
               viewModel.onCategorySelected(category)
            },
            role = Role.RadioButton
         )
         .padding(horizontal = 16.dp),
      verticalAlignment = Alignment.CenterVertically
   ) {
      RadioButton(
         selected = selectedCategory == category,
         onClick = null
      )
      Text(
         text = category.name,
         style = MaterialTheme.typography.bodyMedium,
         color = MaterialTheme.colorScheme.onPrimary,
         modifier = Modifier.padding(start = 16.dp)
      )
   }
}
