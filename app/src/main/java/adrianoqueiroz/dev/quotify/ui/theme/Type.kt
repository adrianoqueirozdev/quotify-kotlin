package adrianoqueiroz.dev.quotify.ui.theme

import adrianoqueiroz.dev.quotify.R
import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private val customFont = FontFamily(
   Font(R.font.montserrat_regular),
   Font(R.font.montserrat_medium, FontWeight.W500),
   Font(R.font.montserrat_semi_bold, FontWeight.W600),
   Font(R.font.montserrat_bold, FontWeight.W700)
)

val Typography = Typography(
   displayLarge = TextStyle(
      fontFamily = customFont,
      fontSize = 57.sp,
      lineHeight = 64.sp,
      letterSpacing = (-0.25).sp,
      fontWeight = FontWeight.Normal
   ),
   displayMedium = TextStyle(
      fontFamily = customFont,
      fontSize = 45.sp,
      lineHeight = 52.sp,
      letterSpacing = 0.sp,
      fontWeight = FontWeight.Normal
   ),
   displaySmall = TextStyle(
      fontFamily = customFont,
      fontSize = 36.sp,
      lineHeight = 44.sp,
      letterSpacing = 0.sp,
      fontWeight = FontWeight.Normal
   ),
   headlineLarge = TextStyle(
      fontFamily = customFont,
      fontSize = 32.sp,
      lineHeight = 40.sp,
      letterSpacing = 0.sp,
      fontWeight = FontWeight.Normal
   ),
   headlineMedium = TextStyle(
      fontFamily = customFont,
      fontSize = 28.sp,
      lineHeight = 36.sp,
      letterSpacing = 0.sp,
      fontWeight = FontWeight.Normal
   ),
   headlineSmall = TextStyle(
      fontFamily = customFont,
      fontSize = 24.sp,
      lineHeight = 32.sp,
      letterSpacing = 0.sp,
      fontWeight = FontWeight.Normal
   ),
   titleLarge = TextStyle(
      fontFamily = customFont,
      fontSize = 22.sp,
      lineHeight = 28.sp,
      letterSpacing = 0.sp,
      fontWeight = FontWeight.Normal
   ),
   titleMedium = TextStyle(
      fontFamily = customFont,
      fontSize = 16.sp,
      lineHeight = 24.sp,
      letterSpacing = 0.15.sp,
      fontWeight = FontWeight.Medium
   ),
   titleSmall = TextStyle(
      fontFamily = customFont,
      fontSize = 14.sp,
      lineHeight = 20.sp,
      letterSpacing = 0.1.sp,
      fontWeight = FontWeight.Medium
   ),
   labelLarge = TextStyle(
      fontFamily = customFont,
      fontSize = 14.sp,
      lineHeight = 20.sp,
      letterSpacing = 0.1.sp,
      fontWeight = FontWeight.Medium
   ),
   labelMedium = TextStyle(
      fontFamily = customFont,
      fontSize = 12.sp,
      lineHeight = 16.sp,
      letterSpacing = 0.5.sp,
      fontWeight = FontWeight.Medium
   ),
   labelSmall = TextStyle(
      fontFamily = customFont,
      fontSize = 11.sp,
      lineHeight = 16.sp,
      letterSpacing = 0.5.sp,
      fontWeight = FontWeight.Medium
   ),
   bodyLarge = TextStyle(
      fontFamily = customFont,
      fontSize = 16.sp,
      lineHeight = 24.sp,
      letterSpacing = 0.5.sp,
      fontWeight = FontWeight.Normal
   ),
   bodyMedium = TextStyle(
      fontFamily = customFont,
      fontSize = 14.sp,
      lineHeight = 20.sp,
      letterSpacing = 0.25.sp,
      fontWeight = FontWeight.Normal
   ),
   bodySmall = TextStyle(
      fontFamily = customFont,
      fontSize = 12.sp,
      lineHeight = 16.sp,
      letterSpacing = 0.4.sp,
      fontWeight = FontWeight.Normal
   )
)
