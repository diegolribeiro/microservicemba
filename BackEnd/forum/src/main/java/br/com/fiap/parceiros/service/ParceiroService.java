package br.com.fiap.parceiros.service;

import br.com.fiap.parceiros.entity.Parceiro;
import br.com.fiap.parceiros.entity.vo.ParceiroVo;
import br.com.fiap.parceiros.repository.ParceiroRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParceiroService {

	@Autowired
	private ParceiroRepository repository;

	public List<ParceiroVo> findAll() {
		return repository.findAll().stream().map(ParceiroVo::new).collect(Collectors.toList());
	}

	public Parceiro salvaParceiro(ParceiroVo parceiroVo){
		return repository.save(new Parceiro(parceiroVo));
	}

}
