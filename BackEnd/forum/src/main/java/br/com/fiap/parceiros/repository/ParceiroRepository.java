package br.com.fiap.parceiros.repository;

import br.com.fiap.parceiros.entity.Parceiro;
import java.util.Collection;
import org.springframework.data.repository.CrudRepository;

public interface ParceiroRepository extends CrudRepository<Parceiro, Long>{

    Collection<Parceiro> findAll();

}
