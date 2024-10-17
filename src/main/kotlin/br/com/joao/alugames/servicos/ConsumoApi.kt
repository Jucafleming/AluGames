package br.com.joao.alugames.servicos

import br.com.joao.alugames.modelo.InfoJogo
import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class ConsumoApi {
    fun buscaJogo(busca: String): InfoJogo?{

        var retorno:InfoJogo? = null

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=$busca"))
            .build()

        val response = client.send(request, BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()

        var meuInfoJogo: InfoJogo? = null

        val resultado = runCatching {
            meuInfoJogo = gson.fromJson(json, InfoJogo::class.java)
        }

        resultado.onSuccess {
            retorno = meuInfoJogo
        }

        resultado.onFailure {
            print("Jogo não existe tente outro id \n")

        }

        return retorno
    }

}