package br.com.omnisoftapi.api;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import br.com.omnisoftapi.domain.entity.Produto;
import br.com.omnisoftapi.model.dto.ProdutoComSkuDTO;
import br.com.omnisoftapi.model.dto.ProdutoDTO;
import br.com.omnisoftapi.model.dto.ProdutoDetalheDTO;
import br.com.omnisoftapi.model.input.ProdutoInput;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;

@Tag(name = "Produtos")
public interface ControlleProdutoOpenApi extends ContrrollerOrigin {

	@Operation(summary = "Listar Produtos")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Produto  Encotrado", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class)) }),
			@ApiResponse(responseCode = "400", description = "Requisão Invaldia", content = @Content),
			@ApiResponse(responseCode = "404", description = "Produto não encontrado", content = @Content) })
	ResponseEntity<Page<ProdutoComSkuDTO>> listar(String parametro, Integer pagina, Integer size, Pageable page);

	ResponseEntity<ProdutoDetalheDTO> buscar(@Param(value = "ID de um SubGrupo") Long id);
	@Operation(summary = "Salvar um Produto ")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Produto salvo com sucesso"),
			@ApiResponse(responseCode = "400", description = "problema com resquisão") })
	public ResponseEntity<ProdutoDTO> criar(@Param(value = "corpo") ProdutoInput produto, HttpServletResponse response);

	@Operation(summary = "Atualizar um Produto ")
	@ApiResponses(value = { @ApiResponse(responseCode = "204", description = "Produto Atualizado com sucesso"),
			@ApiResponse(responseCode = "400", description = "problema com resquisão") })
	ResponseEntity<ProdutoDTO> Atualizar( @Param(value = "id")Long id,  @Param(value = "corpo") ProdutoInput produto, HttpServletResponse response);

	
}
