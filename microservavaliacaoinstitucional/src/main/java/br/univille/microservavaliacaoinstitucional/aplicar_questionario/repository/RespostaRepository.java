package br.univille.microservavaliacaoinstitucional.aplicar_questionario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.univille.microservavaliacaoinstitucional.aplicar_questionario.entity.Resposta;

@Repository
public interface RespostaRepository extends CrudRepository<Resposta,String>{
    
}
