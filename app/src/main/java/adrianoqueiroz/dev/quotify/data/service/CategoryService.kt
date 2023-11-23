package adrianoqueiroz.dev.quotify.data.service

import adrianoqueiroz.dev.quotify.data.model.CategoryResponse
import retrofit2.http.GET

interface CategoryService {
   @GET("categories")
   suspend fun loadCategories(): CategoryResponse
}