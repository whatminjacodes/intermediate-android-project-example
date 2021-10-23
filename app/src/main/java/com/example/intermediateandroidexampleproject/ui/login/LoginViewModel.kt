package com.example.intermediateandroidexampleproject.ui.login

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.intermediateandroidexampleproject.data.PokemonRepository
import com.example.intermediateandroidexampleproject.data.PokemonRequest
import kotlinx.coroutines.*
import com.example.intermediateandroidexampleproject.data.GitHubNetworkApi
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.intermediateandroidexampleproject.data.AccessToken
import retrofit2.Callback
import retrofit2.Response


class LoginViewModel(
    val sharedPreferences: SharedPreferences,
    val pokemonRepository: PokemonRepository
) : ViewModel() {

    val redirectUri: String = "logintest://callback"
    val clientId: String = "bd3f948fa6dde4f62a6e"
    val clientSecret: String = ""

    val loginValidity = MutableLiveData<Boolean>()

    fun isLoginValid(validity: Boolean) {
        loginValidity.postValue(validity)
    }

    fun validateToken2() = CoroutineScope(Dispatchers.IO).launch(CoroutineExceptionHandler { _, throwable ->
        // todo: other error cases that are not handled in the coroutine?
        //  isLoginValid.postValue(false)
        //  EspressoTestRunner.resume()
    }) {
        //  EspressoTestRunner.pause()
        /*  val whoAmIResponse = asmoRepository.whoAmI()
          val email = whoAmIResponse.body()!!.username.removePrefix("Azure_")

          val response = asmoRepository.getEmployees(email)
          response.body()?.employees?.firstOrNull()?.serviceEmployeeCode?.let {
              sharedPreferences.edit {
                  putString(AsmoApplication.PREF_LN_USER_LOGIN_CODE, it)
                  commit()
              }
              isLoginValid.postValue(true)
              EspressoTestRunner.resume()
          }*/
    }

    fun validateGithubToken(code: String) {
        val builder = Retrofit.Builder()
            .baseUrl("https://github.com/")
            .addConverterFactory(GsonConverterFactory.create())

        val retrofit = builder.build()

        val client: GitHubNetworkApi = retrofit.create(GitHubNetworkApi::class.java)
        val accessTokenCall: Call<AccessToken> = client.getAccessToken(clientId, clientSecret, code)

        accessTokenCall.enqueue(object : Callback<AccessToken?> {
            override fun onResponse(call: Call<AccessToken?>?, response: Response<AccessToken?>?) {
                Log.d("test", "test success")
            }

            override fun onFailure(call: Call<AccessToken?>?, t: Throwable?) {
                Log.d("test", "test failure")
            }
        })
    }

    fun validateToken() = CoroutineScope(Dispatchers.IO).launch {
        val pokemonResponse = pokemonRepository.getPokemon(PokemonRequest(10))

        withContext(Dispatchers.Main) {
            //listOfPokemon.postValue(pokemonResponse.results)
            Log.d("test", pokemonResponse.results[0].name)
            Log.d("test", pokemonResponse.results[1].name)

            loginValidity.postValue(true)
        }
    }
}