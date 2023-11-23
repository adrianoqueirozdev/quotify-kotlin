package adrianoqueiroz.dev.quotify.data.service

import adrianoqueiroz.dev.quotify.data.model.PhraseResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PhraseService {
   @GET("phrases")
   suspend fun loadPhraseByCategory(@Query("categoryId") categoryId: String): PhraseResponse

   @GET("phrases")
   suspend fun loadPhrase(): PhraseResponse
}