package casadocodigokotlin.livro

import casadocodigokotlin.autor.AutorRepository
import casadocodigokotlin.categoria.CategoriaRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI
import javax.validation.Valid

@RestController
@RequestMapping("/api/livro")
class LivroController(
    private val livroRepository: LivroRepository,
    private val autorRepository: AutorRepository,
    private val categoriaRepository: CategoriaRepository
) {

    @PostMapping
    fun cria(@Valid @RequestBody request: LivroRequest, uriBuilder: UriComponentsBuilder): ResponseEntity<Any> {

        val autor = autorRepository.findById(request.autor).get()
        val categoria = categoriaRepository.findById(request.categoria).get()

        val livro = request.toModel(autor, categoria)
        livroRepository.save(livro)

        val location: URI = uriBuilder
            .path("/api/categoria/{id}")
            .buildAndExpand(livro.id)
            .toUri()

        return ResponseEntity.created(location).build()
    }
}