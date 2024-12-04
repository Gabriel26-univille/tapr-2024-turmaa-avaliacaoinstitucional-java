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

import br.univille.microservavaliacaoinstitucional.aplicar_questionario.entity.Resposta;
import br.univille.microservavaliacaoinstitucional.aplicar_questionario.service.RespostaService;

@RestController
@RequestMapping("/api/v1/aplicarQuestionario")
public class RespostaAPIController {
    @Autowired
    private RespostaService service;

    @GetMapping
    public ResponseEntity<List<Resposta>> get(){
        var listaRespostas = service.getAll();

        return new ResponseEntity<List<Resposta>>(listaRespostas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Resposta> post(@RequestBody Resposta resposta){
        if (resposta == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var respostaSalvo = service.save(resposta);
        return new ResponseEntity<Resposta>(respostaSalvo, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resposta> put(
                    @PathVariable("id") String id,
                    @RequestBody Resposta resposta){
        if(resposta == null || id == "" || id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        resposta = service.update(id, resposta);
        if(resposta == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Resposta>(resposta,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Resposta> delete(
                    @PathVariable("id") String id){
        if(id == "" || id == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var resposta = service.delete(id);
        if(resposta == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Resposta>(resposta,HttpStatus.OK);
    }

}
