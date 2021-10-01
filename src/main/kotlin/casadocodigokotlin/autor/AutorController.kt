package casadocodigokotlin.autor

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI
import javax.validation.Valid

@RestController
@RequestMapping("/api/autor")
class AutorController(private val autorRepository: AutorRepository) {

    @PostMapping
    fun cria(@Valid @RequestBody autorRequest: AutorRequest, uriBuilder: UriComponentsBuilder): ResponseEntity<Any> {

        val autor = autorRequest.toModel()
        autorRepository.save(autor)

        val location: URI = uriBuilder
            .path("/api/autor/{id}")
            .buildAndExpand(autor.id)
            .toUri()

        return ResponseEntity.created(location).build()
    }
}