package casadocodigokotlin.autor

import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
class Autor(
    @field:NotBlank val nome: String,
    @Column(unique = true)
    @field:NotBlank @field:Email val email: String,
    @Column(length = 400)
    @field:NotBlank @field:Size(max = 400) val descricao: String
){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    val id: Long? = null
    private val dataCadastro: LocalDateTime = LocalDateTime.now()
}