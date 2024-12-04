package br.univille.microservavaliacaoinstitucional.aplicar_questionario.service;

import java.util.List;

import br.univille.microservavaliacaoinstitucional.aplicar_questionario.entity.Resposta;

public interface RespostaService {
    List<Resposta> getAll();
    Resposta save(Resposta resposta);
    Resposta update(String id, Resposta resposta);
    Resposta delete(String id);
}
