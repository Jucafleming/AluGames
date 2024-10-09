data class Jogo(val titulo: String, val capa: String ) {
    var descricao = ""

    override fun toString(): String {
        return "Jogo(\n titulo='$titulo', \n capa='$capa', \n descricao='$descricao')"
    }
}