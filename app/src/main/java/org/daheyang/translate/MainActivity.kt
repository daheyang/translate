package org.daheyang.translate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.daheyang.translate.model.PapagoEntity
import org.daheyang.translate.model.PapagoServiceCreator
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val papagoService = PapagoServiceCreator().create()
        val call = papagoService.requestTranslation()
        call.enqueue(object : retrofit2.Callback<PapagoEntity> {
            override fun onResponse(call: Call<PapagoEntity>, response: Response<PapagoEntity>) {
                val result = response.body()

                Log.d("요청 성공!", "${result?.message}")
            }

            override fun onFailure(call: Call<PapagoEntity>, t: Throwable) {
                Log.d("요청 실패", "onFailure!")
                t.printStackTrace()
            }
        })
    }
}