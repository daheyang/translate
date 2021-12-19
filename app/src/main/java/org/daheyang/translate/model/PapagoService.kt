package org.daheyang.translate.model

import org.daheyang.translate.sourceText
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface PapagoService {
    @FormUrlEncoded
    @POST("n2mt")
    fun requestTranslation(@Header("X-Naver-Client-Id")clientID: String = Configs.clientID,
                           @Header("X-Naver-Client-Secret")apiKey: String = Configs.apiKey,
                           @Field("source")fromLang: String = "en",
                           @Field("target")toLang: String = "ko",
                           @Field("text")text: String? = sourceText ) : Call<PapagoEntity>

}