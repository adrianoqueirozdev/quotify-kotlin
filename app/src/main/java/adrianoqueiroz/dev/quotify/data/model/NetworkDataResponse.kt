package adrianoqueiroz.dev.quotify.data.model

data class NetworkDataResponse<T>(
   var data: T,
   var message: String = ""
)
