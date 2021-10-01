package casadocodigokotlin.categoria

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class Categoria (
    @Column(unique = true)
    @field:NotBlank val nome: String
        ) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    val id: Long? = null
}
