package adrianoqueiroz.dev.quotify.data.repository

import adrianoqueiroz.dev.quotify.data.network.RetrofitClient
import adrianoqueiroz.dev.quotify.data.service.CategoryService

class CategoryRepository {
   private val categoryService = RetrofitClient.getService(CategoryService::class.java)

   suspend fun loadCategories() = categoryService.loadCategories()
}