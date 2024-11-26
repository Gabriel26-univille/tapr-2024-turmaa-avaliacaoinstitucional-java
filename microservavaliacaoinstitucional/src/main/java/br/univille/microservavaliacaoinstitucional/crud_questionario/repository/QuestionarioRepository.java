package br.univille.microservavaliacaoinstitucional.crud_questionario.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.univille.microservavaliacaoinstitucional.crud_questionario.entity.Questionario;

@Repository
public interface QuestionarioRepository extends CrudRepository<Questionario,String>{
    
}
