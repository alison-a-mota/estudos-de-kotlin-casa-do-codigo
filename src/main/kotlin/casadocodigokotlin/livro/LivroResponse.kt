package casadocodigokotlin.livro

import org.springframework.data.domain.Page

data class LivroResponse(
    val id: Long,
    val titulo: String
) {
    companion object {
        fun of(livros: Page<Livro>): Page<LivroResponse> =
            livros.map { LivroResponse(id = it.id!!, titulo = it.titulo) }
    }
}