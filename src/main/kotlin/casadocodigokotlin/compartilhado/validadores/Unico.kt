package casadocodigokotlin.compartilhado.validadores

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [UnicoValidator::class])
@MustBeDocumented
annotation class Unico(
    val message: String = "Este campo já existe no banco de dados",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = [],
    val fieldName: String,
    val entityClass: KClass<*>
)
