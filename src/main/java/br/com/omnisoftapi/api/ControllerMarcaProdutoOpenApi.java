package br.com.omnisoftapi.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import br.com.omnisoftapi.domain.entity.SubGrupo;
import br.com.omnisoftapi.model.dto.MarcaProdutoDTO;
import br.com.omnisoftapi.model.input.MarcaProdutoInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
@Tag(name = "Marca")
public interface ControllerMarcaProdutoOpenApi extends ContrrollerOrigin{
	
	@Operation(summary = "Listar Marcas")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Marca  Encotrada", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = SubGrupo.class)) }),
			@ApiResponse(responseCode = "400", description = "Requisão Invaldia", content = @Content),
			@ApiResponse(responseCode = "404", description = "Marca não encontrada", content = @Content) })
	ResponseEntity<Page<MarcaProdutoDTO>> listar(String parametro, Integer pagina, Integer size,
			Pageable page);

	@Operation(summary = "Excluir uma Marca por id")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Marca excluída"),
			@ApiResponse(responseCode = "404", description = "Marca não encontrada") })

	ResponseEntity<Void> remover(@Param(value = "ID de uma Marca") Long id);

	ResponseEntity<MarcaProdutoDTO> buscar(@Param(value = "ID de um Marca") Long id);
	@Operation(summary = "Atualizar uma Marca ")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Marca Atualizada com sucesso"),
			@ApiResponse(responseCode = "400", description = "problema com resquisão") })
	ResponseEntity<MarcaProdutoDTO> Atualizar( @Param(value = "id")Long id,  @Param(value = "corpo") MarcaProdutoInput marca, HttpServletResponse response);

	@Operation(summary = "Salvar um Marca ")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Marca salva com sucesso"),
			@ApiResponse(responseCode = "400", description = "problema com resquisão") })
	public ResponseEntity<MarcaProdutoDTO> criar(@Param(value = "corpo") MarcaProdutoInput marca, HttpServletResponse response);

}
