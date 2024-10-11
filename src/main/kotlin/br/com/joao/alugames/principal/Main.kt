package br.com.joao.alugames.principal

import br.com.joao.alugames.modelo.Jogo
import br.com.joao.alugames.modelo.InfoJogo
import br.com.joao.alugames.servicos.ConsumoApi
import java.util.Scanner
fun main() {
    val leitura = Scanner(System.`in`)
    println("Digite um código de jogo para buscar: ")
    val busca = leitura.nextLine()

    val buscaApi = ConsumoApi()
    val meuInfoJogo: InfoJogo? = buscaApi.buscaJogo(busca)
    var meuJogo: Jogo? = null

    meuInfoJogo?.let { infoJogo ->
         meuJogo = Jogo(
            infoJogo.info.title,
            infoJogo.info.thumb
        )
        println("Deseja inserir descrição? S/N: ")
        val opcao = leitura.nextLine()
        if (opcao.equals("S", true)) {
            print("Insira descrição personalizada: ")
            val descricaoPers = leitura.nextLine()
            meuJogo.descricao = descricaoPers
        } else {
            meuJogo.descricao = meuJogo.titulo
        }
    }

    print(meuJogo)
}
