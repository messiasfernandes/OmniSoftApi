package br.com.omnisoftapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.omnisoftapi.api.SubGupoControllerOpenApi;
import br.com.omnisoftapi.converter.SubGrupoConverter;
import br.com.omnisoftapi.domain.service.ServiceSubgrupo;
import br.com.omnisoftapi.model.dto.SubGrupoDTO;
import br.com.omnisoftapi.model.input.SubGrupoInput;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/subgrupos")
public class ControllerSubGrupo implements SubGupoControllerOpenApi {

	@Autowired
	private ServiceSubgrupo serviceSubgrupo;
	@Autowired
	private SubGrupoConverter subGrupoConverter;

	@GetMapping
	@Override
	public ResponseEntity<Page<SubGrupoDTO>> listar(
			@RequestParam(value = "parametro", required = false, defaultValue = "") String parametro,
			@RequestParam(value = "page", defaultValue = "0") Integer pagina,
			@RequestParam(value = "size", defaultValue = "10") Integer size, Pageable page) {

		return ResponseEntity.status(HttpStatus.OK)
				.body(subGrupoConverter.topage(serviceSubgrupo.buscar(parametro, page)));
	}

	@DeleteMapping("/{id}")
	@Override
	public ResponseEntity<Void> remover(@ PathVariable Long id) {
		serviceSubgrupo.excluir(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	public ResponseEntity<SubGrupoDTO> buscar(Long id) {

		return null;
	}

	@PutMapping("/{id}")
	@Override
	public ResponseEntity<SubGrupoDTO> Atualizar(@PathVariable Long id, @Valid @RequestBody SubGrupoInput subgrupo,
			HttpServletResponse response) {
		subgrupo.setId(id);
		var subsalvo = serviceSubgrupo.salvar(subGrupoConverter.toEntity(subgrupo));
		return ResponseEntity.status(HttpStatus.OK).body(subGrupoConverter.toDto(subsalvo));
	}

	@PostMapping
	@Override
	public ResponseEntity<SubGrupoDTO> criar(@Valid @RequestBody SubGrupoInput subgrupo, HttpServletResponse response) {
		var subsalvo   = serviceSubgrupo.salvar(subGrupoConverter.toEntity(subgrupo));
		return ResponseEntity.status(HttpStatus.CREATED).body(subGrupoConverter.toDto(subsalvo));
	}

}
