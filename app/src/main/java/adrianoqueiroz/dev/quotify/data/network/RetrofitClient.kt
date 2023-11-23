package adrianoqueiroz.dev.quotify.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor() {
   companion object {
      private const val BASE_URL = "https://thelucasdev.cloud/"
      private lateinit var RETROFIT: Retrofit

      private fun getRetrofitInstance(): Retrofit {
         if (!::RETROFIT.isInitialized) {
            RETROFIT = Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build()
         }
         return RETROFIT
      }

      fun <T> getService(serviceClass: Class<T>): T {
         return getRetrofitInstance().create(serviceClass)
      }
   }
}