package casadocodigokotlin.autor

import casadocodigokotlin.compartilhado.validadores.Unico
import javax.persistence.Column
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size


data class AutorRequest(
    @field:NotBlank val nome: String,
    @field:NotBlank @field:Email @field:Unico(fieldName = "email", entityClass = Autor::class) val email: String,
    @Column(length = 400)
    @field:NotBlank @field:Size(max = 400) val descricao: String
) {
    fun toModel(): Autor {
        return Autor(nome = this.nome, email = this.email, descricao = this.descricao)
    }
}
