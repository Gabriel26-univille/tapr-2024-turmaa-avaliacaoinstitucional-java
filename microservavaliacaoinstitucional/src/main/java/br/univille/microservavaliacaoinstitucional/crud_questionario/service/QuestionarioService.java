package br.univille.microservavaliacaoinstitucional.crud_questionario.service;

import java.util.List;

import br.univille.microservavaliacaoinstitucional.crud_questionario.entity.Questionario;

public interface QuestionarioService {
    List<Questionario> getAll();
    Questionario save(Questionario questionario);
    Questionario update(String id, Questionario questionario);
    Questionario delete(String id);
}
