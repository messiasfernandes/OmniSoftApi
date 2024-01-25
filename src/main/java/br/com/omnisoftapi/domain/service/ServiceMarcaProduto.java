package br.com.omnisoftapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.omnisoftapi.domain.dao.DaoMarcaProduto;
import br.com.omnisoftapi.domain.entity.MarcaProduto;
import br.com.omnisoftapi.domain.service.exeption.EntidadeEmUsoExeption;
import br.com.omnisoftapi.domain.service.exeption.NegocioException;
import br.com.omnisoftapi.domain.service.exeption.RegistroNaoEncontrado;
import br.com.omnisoftapi.utils.TolowerCase;

@Service
public class ServiceMarcaProduto implements ServiceModel<MarcaProduto> {
	@Autowired
	private DaoMarcaProduto daoMarcaProduto;

	@Override
	public Page<MarcaProduto> buscar(String nome, Pageable pageable) {
		nome = TolowerCase.normalizarString(nome);
		return daoMarcaProduto.search(nome, pageable);
	}

	@Override
	public void excluir(Long codigo) {
		buccarporid(codigo);
		try {
			daoMarcaProduto.deleteById(codigo);
			daoMarcaProduto.flush();
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoExeption(
					"Operação não permitida!! Este registro pode estar asssociado a outra tabela");
		}

	}

	@Override
	public MarcaProduto buccarporid(Long id) {
		if (daoMarcaProduto.findById(id).isEmpty()) {
			throw new RegistroNaoEncontrado("Subcategoria não encotrada");
		}
		return daoMarcaProduto.findById(id).get();
	}

	@Override
	public MarcaProduto salvar(MarcaProduto objeto) {
		var nome = TolowerCase.normalizarString(objeto.getNomeMarca());

		MarcaProduto marcaExistente = daoMarcaProduto.buscar(nome);
		if (marcaExistente != null && !marcaExistente.equals(objeto)) {
			throw new NegocioException("Marca já cadastrada no banco de dados");
		}

		if (marcaExistente == null) {
			return daoMarcaProduto.save(objeto);
		} else {
			return marcaExistente;
		}

	}

}
