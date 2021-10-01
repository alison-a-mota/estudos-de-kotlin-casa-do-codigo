package casadocodigokotlin.livro

import org.springframework.data.jpa.repository.JpaRepository

interface LivroRepository: JpaRepository<Livro, Long> {

}
