package casadocodigokotlin.compartilhado.validadores

import javax.validation.Constraint
import javax.validation.Payload
import kotlin.reflect.KClass

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@Constraint(validatedBy = [ExistsIdValidator::class])
@MustBeDocumented
annotation class ExistsById(
    val message: String = "ID não encontrado.",
    val groups: Array<KClass<Any>> = [],
    val payload: Array<KClass<Payload>> = [],
    val fieldName: String,
    val entityClass: KClass<*>
)
