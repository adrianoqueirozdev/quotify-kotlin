package adrianoqueiroz.dev.quotify.view.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PhraseMaster(phraseMaster: String) {
   val textColor = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.75f)

   Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.End,
      verticalAlignment = Alignment.CenterVertically
   ) {
      Box(
         modifier = Modifier
            .height(1.5.dp)
            .width(24.dp)
            .background(textColor)
      )
      Spacer(modifier = Modifier.width(8.dp))
      Text(
         text = phraseMaster,
         textAlign = TextAlign.End,
         style = MaterialTheme.typography.labelMedium.copy(
            fontWeight = FontWeight.SemiBold
         ),
         color = textColor
      )
   }
}

@Preview
@Composable
fun PreviewPhraseMaster() {
   PhraseMaster(phraseMaster = "Machado de Assis")
}