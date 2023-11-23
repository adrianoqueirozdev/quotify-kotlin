package adrianoqueiroz.dev.quotify.viewmodel

import adrianoqueiroz.dev.quotify.data.constants.DefaultErrorNetwork
import adrianoqueiroz.dev.quotify.data.constants.Images
import adrianoqueiroz.dev.quotify.data.model.CategoryModel
import adrianoqueiroz.dev.quotify.data.model.NetworkDataResponse
import adrianoqueiroz.dev.quotify.data.model.PhraseModel
import adrianoqueiroz.dev.quotify.data.repository.CategoryRepository
import adrianoqueiroz.dev.quotify.data.repository.PhraseRepository
import adrianoqueiroz.dev.quotify.data.utils.getImageByCategory
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.ContentCopy
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeScreenViewModel(private val context: Context) : ViewModel() {
   private val phraseRepository = PhraseRepository()
   private val categoryRepository = CategoryRepository()

   private val _backgroundImage = MutableStateFlow(value = Images.PRIMARY)
   private val _iconCopy = MutableStateFlow(value = Icons.Filled.ContentCopy)
   private val _phraseResponse = MutableStateFlow(
      value = NetworkDataResponse(data = PhraseModel(), message = "")
   )
   private val _categoryResponse = MutableStateFlow(
      value = NetworkDataResponse(data = emptyList<CategoryModel>(), message = "")
   )
   private val _selectedCategory = MutableStateFlow(
      value = CategoryModel(name = "Selecione uma categoria", id = "")
   )

   val backgroundImage = _backgroundImage
   val iconCopy = _iconCopy
   val phraseResponse = _phraseResponse
   val categoryResponse = _categoryResponse
   val selectedCategory = _selectedCategory

   init {
      loadPhrase()
      loadCategories()
   }

   fun onCategorySelected(category: CategoryModel) {
      _backgroundImage.value = getImageByCategory(category.name)
      _selectedCategory.value = category
      loadPhrase()
   }

   fun copyToClipboard() {
      viewModelScope.launch {
         _iconCopy.value = Icons.Filled.Check

         val clipboard = ContextCompat.getSystemService(context, ClipboardManager::class.java)
         val phrase = phraseResponse.value.data
         val formatPhrase = "${phrase.content}\n\n${phrase.phraseMaster}"
         val clip = ClipData.newPlainText("label", formatPhrase)
         clipboard?.setPrimaryClip(clip)

         delay(timeMillis = 3000)
         _iconCopy.value = Icons.Filled.ContentCopy
      }
   }

   fun loadPhrase() {
      viewModelScope.launch {
         try {
            val result = when (selectedCategory.value.id) {
               "" -> phraseRepository.loadPhrase().data
               else -> phraseRepository.loadPhraseByCategory(selectedCategory.value.id).data
            }
            _phraseResponse.value = NetworkDataResponse(data = result!!, message = "")
         } catch (e: Exception) {
            _phraseResponse.value = NetworkDataResponse(
               data = PhraseModel(),
               message = DefaultErrorNetwork.DEFAULT_ERROR_NETWORK
            )
         }
      }
   }

   private fun loadCategories() {
      viewModelScope.launch {
         try {
            val result = categoryRepository.loadCategories().data
            _categoryResponse.value = NetworkDataResponse(data = result, message = "")
         } catch (e: Exception) {
            _categoryResponse.value = NetworkDataResponse(
               data = emptyList(),
               message = DefaultErrorNetwork.DEFAULT_ERROR_NETWORK
            )
         }
      }
   }
}