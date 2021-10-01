package casadocodigokotlin.livro

import casadocodigokotlin.autor.Autor
import casadocodigokotlin.categoria.Categoria
import casadocodigokotlin.compartilhado.validadores.Unico
import java.math.BigDecimal
import java.time.LocalDate
import javax.persistence.*
import javax.validation.constraints.*

@Entity
class Livro(
    @Column(unique = true)
    @field:NotBlank val titulo: String,
    @Column(length = 500)
    @field:NotBlank @field:Size(max = 500) val resumo: String,
    val sumario: String,
    @field:NotBlank val lsbn: String,
    @field:Future val dataPublicacao: LocalDate,
    @field:NotNull @field:Min(20) val preco: BigDecimal,
    @field:NotNull @field:Min(100) val paginas: Int,
    @ManyToOne
    @field:NotNull val categoria: Categoria,
    @ManyToOne
    @field:NotNull val autor: Autor
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    val id: Long? = null
}