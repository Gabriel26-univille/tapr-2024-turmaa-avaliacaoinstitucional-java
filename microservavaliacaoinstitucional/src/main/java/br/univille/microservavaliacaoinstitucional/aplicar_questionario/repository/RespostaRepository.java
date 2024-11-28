package br.univille.microservavaliacaoinstitucional.aplicar_questionario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.univille.microservavaliacaoinstitucional.crud_questionario.entity.Questionario;

@Repository
public interface RespostaRepository extends CrudRepository<Questionario,String>{
    
}
