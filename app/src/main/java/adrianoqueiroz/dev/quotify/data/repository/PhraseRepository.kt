package adrianoqueiroz.dev.quotify.data.repository

import adrianoqueiroz.dev.quotify.data.model.PhraseResponse
import adrianoqueiroz.dev.quotify.data.network.RetrofitClient
import adrianoqueiroz.dev.quotify.data.service.PhraseService

class PhraseRepository {
   private val phraseService = RetrofitClient.getService(PhraseService::class.java)

   suspend fun loadPhrase(): PhraseResponse = phraseService.loadPhrase()

   suspend fun loadPhraseByCategory(categoryId: String): PhraseResponse = phraseService.loadPhraseByCategory(categoryId)
}