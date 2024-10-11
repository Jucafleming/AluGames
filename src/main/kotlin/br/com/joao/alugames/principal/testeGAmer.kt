import br.com.joao.alugames.modelo.Gamer

fun main() {
  val gamer1 = Gamer(
    "jaque",
    "jaque@emaul.com"
  )
  print(gamer1 )
  print("\n")
  val gamer2 = Gamer(
    "Jeni",
    "Jeni@Gmail.com",
    "19/09/1992",
    "jenny"
  )
  print(gamer2)
  print("\n")

  gamer1.let {
    it.dataNasc = "10/02/2001"
    it.usuario = "jaquest"
  }.also {
    print(gamer1)
  }

  print("\n")
}


