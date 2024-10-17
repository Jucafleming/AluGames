package br.com.joao.alugames.principal

import br.com.joao.alugames.modelo.Gamer
import br.com.joao.alugames.modelo.Jogo
import br.com.joao.alugames.modelo.InfoJogo
import br.com.joao.alugames.servicos.ConsumoApi
import java.util.Scanner

fun main() {
  val leitura = Scanner(System.`in`)

  val gamer = Gamer.criarGamer(leitura)
  print("Cadastro Concluido \n")
  print(gamer)

  do {
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
      gamer.jogosBuscados.add(meuJogo)
    }
    print("Deseja buscar um novo jogo? S/N: ")
    val resposta = leitura.nextLine();

  } while (resposta.equals("S", true))
  print("busca finalizada")
  print(gamer.jogosBuscados)

  print("jogos por tilutlo: \n")

  gamer.jogosBuscados.sortBy {
    it?.titulo
  }
  gamer.jogosBuscados.forEach {
    print("Titulo: ${it?.titulo} \n")
  }

  val jogosFiltrados = gamer.jogosBuscados.filter {
    it?.titulo?.contains("batman", true) ?: false
  }
  println("\n Jogos filtrados: ")
  println(jogosFiltrados)

  println("Deseja excluir algum jogo da lista original? S/N")
  val opcao = leitura.nextLine()
  if (opcao.equals("s", true)) {
    println(gamer.jogosBuscados)
    println("\n Informe a posição do jogo que deseja excluir: ")
    val posicao = leitura.nextInt()
    gamer.jogosBuscados.removeAt(posicao)
  }

  println("\n Lista atualizada:")
  println(gamer.jogosBuscados)
}
