package casadocodigokotlin.livro

import casadocodigokotlin.autor.Autor
import casadocodigokotlin.categoria.Categoria
import casadocodigokotlin.compartilhado.validadores.ExistsById
import casadocodigokotlin.compartilhado.validadores.Unico
import java.math.BigDecimal
import java.time.LocalDate
import javax.validation.constraints.*

data class LivroRequest(
    @field:NotBlank @field:Unico(fieldName = "titulo", entityClass = Livro::class) val titulo: String,
    @field:NotBlank @field:Size(max = 500) val resumo: String,
    val sumario: String,
    @field:NotBlank @field:Unico(fieldName = "lsbn", entityClass = Livro::class) val lsbn: String,
    @field:Future val dataPublicacao: LocalDate,
    @field:NotNull @field:Min(20) val preco: BigDecimal,
    @field:NotNull @field:Min(100) val paginas: Int,
    @field:NotNull @field:ExistsById(fieldName = "id", entityClass = Categoria::class) val categoria: Long,
    @field:NotNull @field:ExistsById(fieldName = "id", entityClass = Autor::class) val autor: Long
) {
    fun toModel(autor: Autor, categoria: Categoria): Livro {
        return Livro(titulo, resumo, sumario, lsbn, dataPublicacao, preco, paginas, categoria, autor)
    }
}
