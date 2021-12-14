package org.daheyang.translate.model

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST


interface PapagoService {
    @FormUrlEncoded
    @POST("n2mt")
    fun requestTranslation(@Header(" qWJxInEJVNkrMvlTJWwp")clientID: String = Configs.clientID,
                           @Header("VwOHWSAQWT")apiKey: String = Configs.apiKey,
                           @Field("source")fromLang: String = "en",
                           @Field("target")toLang: String = "ko",
                           @Field("text")text: String? = "this is android") : Call<PapagoEntity>
}