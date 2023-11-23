package adrianoqueiroz.dev.quotify.data.model

data class CategoryModel(
   val id: String,
   val name: String
)

data class CategoryResponse(
   val data: List<CategoryModel> = emptyList()
)
