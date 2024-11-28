package br.univille.microservavaliacaoinstitucional.aplicar_questionario.service;

import java.util.List;

import br.univille.microservavaliacaoinstitucional.crud_questionario.entity.Questionario;

public interface RespostaService {
    List<Questionario> getAll();
    Questionario save(Questionario questionario);
    Questionario update(String id, Questionario questionario);
    Questionario delete(String id);
}
