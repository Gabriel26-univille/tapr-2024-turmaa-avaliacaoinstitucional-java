package br.univille.microservavaliacaoinstitucional.aplicar_questionario.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.microservavaliacaoinstitucional.crud_questionario.entity.Questionario;
import br.univille.microservavaliacaoinstitucional.crud_questionario.repository.QuestionarioRepository;
import br.univille.microservavaliacaoinstitucional.crud_questionario.service.QuestionarioService;

@Service
public class QuestionarioServiceImpl implements QuestionarioService {
    
    @Autowired
    private QuestionarioRepository repository;

    @Override
    public List<Questionario> getAll(){
        var retornoIterador = repository.findAll();
        var listaQuestionario = new ArrayList<Questionario>();

        retornoIterador.forEach(listaQuestionario::add);
        return listaQuestionario;
    }

    @Override
    public Questionario save(Questionario questionario){
        return repository.save(questionario);
    }

    @Override
    public Questionario update(String id, Questionario questionario) {
        var buscaQuestionario = repository.findById(id);
        if(buscaQuestionario.isPresent()){
            var questionarioAntigo = buscaQuestionario.get();
            questionarioAntigo.setNome(questionario.getNome());
            repository.save(questionarioAntigo);
            return questionarioAntigo;
        }
        return null;
    }

    @Override
    public Questionario delete(String id) {
        var buscaQuestionario = repository.findById(id);
        if(buscaQuestionario.isPresent()){
            var questionarioAntigo = buscaQuestionario.get();
            repository.delete(questionarioAntigo);
            return questionarioAntigo;
        }
        return null;
    }
}
