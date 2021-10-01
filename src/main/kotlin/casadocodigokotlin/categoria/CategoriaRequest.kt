package casadocodigokotlin.categoria

import casadocodigokotlin.compartilhado.validadores.Unico
import javax.validation.constraints.NotBlank

data class CategoriaRequest(
    @field:NotBlank @field:Unico(fieldName = "nome", entityClass = Categoria::class) val nome: String
) {
    fun toModel(): Categoria {
        return Categoria(nome = this.nome)
    }
}