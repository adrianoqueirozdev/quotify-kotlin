package adrianoqueiroz.dev.quotify.data.utils

import adrianoqueiroz.dev.quotify.data.constants.Images

fun getImageByCategory(name: String) = when (name) {
   "Bíblicos" -> Images.BIBLE
   "Humor" -> Images.HUMOR
   "Motivação" -> Images.MOTIVATION
   "Tecnologia" -> Images.TECHNOLOGY
   else -> Images.PRIMARY
}
