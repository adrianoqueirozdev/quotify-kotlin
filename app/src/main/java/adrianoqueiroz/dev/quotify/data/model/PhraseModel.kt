package adrianoqueiroz.dev.quotify.data.model

data class PhraseModel(
   val id: String? = null,
   val content: String? = null,
   val phraseMaster: String? = null,
)

data class PhraseResponse(
   val data: PhraseModel? = null,
)
