package br.univille.microservavaliacaoinstitucional.aplicar_questionario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.microservavaliacaoinstitucional.crud_questionario.entity.Questionario;
import br.univille.microservavaliacaoinstitucional.crud_questionario.service.QuestionarioService;

@RestController
@RequestMapping("/api/v1/questionarios")
public class RespostaAPIController {
    @Autowired
    private QuestionarioService service;

    @GetMapping
    public ResponseEntity<List<Questionario>> get(){
        var listaQuestionarios = service.getAll();

        return new ResponseEntity<List<Questionario>>(listaQuestionarios, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Questionario> post(@RequestBody Questionario questionario){
        if (questionario == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var questionarioSalvo = service.save(questionario);
        return new ResponseEntity<Questionario>(questionarioSalvo, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Questionario> put(
                    @PathVariable("id") String id,
                    @RequestBody Questionario questionario){
        if(questionario == null || id == "" || id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        questionario = service.update(id, questionario);
        if(questionario == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Questionario>(questionario,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Questionario> delete(
                    @PathVariable("id") String id){
        if(id == "" || id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var questionario = service.delete(id);
        if(questionario == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Questionario>(questionario,HttpStatus.OK);
    }

}
