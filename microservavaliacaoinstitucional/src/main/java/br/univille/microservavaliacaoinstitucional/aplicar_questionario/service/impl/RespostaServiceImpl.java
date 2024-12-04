package br.univille.microservavaliacaoinstitucional.aplicar_questionario.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.microservavaliacaoinstitucional.aplicar_questionario.entity.Resposta;
import br.univille.microservavaliacaoinstitucional.aplicar_questionario.repository.RespostaRepository;
import br.univille.microservavaliacaoinstitucional.aplicar_questionario.service.RespostaService;


@Service
public class RespostaServiceImpl implements RespostaService {
    
    @Autowired
    private RespostaRepository repository;

    @Override
    public List<Resposta> getAll(){
        var retornoIterador = repository.findAll();
        var listaResposta = new ArrayList<Resposta>();

        retornoIterador.forEach(listaResposta::add);
        return listaResposta;
    }

    @Override
    public Resposta save(Resposta resposta){
        return repository.save(resposta);
    }

    @Override
    public Resposta update(String id, Resposta resposta) {
        var buscaResposta = repository.findById(id);
        if(buscaResposta.isPresent()){
            var respostaAntigo = buscaResposta.get();
            respostaAntigo.setQuestionario(resposta.getQuestionario());
            repository.save(respostaAntigo);
            return respostaAntigo;
        }
        return null;
    }

    @Override
    public Resposta delete(String id) {
        var buscaResposta = repository.findById(id);
        if(buscaResposta.isPresent()){
            var respostaAntigo = buscaResposta.get();
            repository.delete(respostaAntigo);
            return respostaAntigo;
        }
        return null;
    }
}
