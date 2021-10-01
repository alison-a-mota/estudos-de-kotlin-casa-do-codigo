package casadocodigokotlin.autor

import org.springframework.data.jpa.repository.JpaRepository

interface AutorRepository: JpaRepository<Autor, Long> {
    fun existsByEmail(email: String): Boolean
}
