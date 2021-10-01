package casadocodigokotlin.categoria

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI
import javax.validation.Valid

@RestController
@RequestMapping("/api/categoria")
class CategoriaNovaController(private val categoriaRepository: CategoriaRepository) {

    @PostMapping
    fun nova(@Valid @RequestBody request: CategoriaRequest, uriBuilder: UriComponentsBuilder): ResponseEntity<Any> {
        val categoria = request.toModel()
        categoriaRepository.save(categoria)

        val location: URI = uriBuilder
            .path("/api/categoria/{id}")
            .buildAndExpand(categoria.id)
            .toUri()

        return ResponseEntity.created(location).build()
    }
}