package br.univille.microservavaliacaoinstitucional.aplicar_questionario.entity;

import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

import br.univille.microservavaliacaoinstitucional.crud_questionario.entity.Questionario;

@Container(containerName = "resposta", autoCreateContainer = true)
public class Resposta {
    @Id
    @PartitionKey
    @GeneratedValue
    private String id;
    private Questionario questionario;
    private String aluno; // vem de outro microserviço
    private String professor; // vem de outro microserviço
    private LocalDateTime dataCriacao;
    private String materia; // vem de outro microserviço

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public LocalDateTime getdataCriacao(){
        return dataCriacao;
    }

    public void setdataCriacao(LocalDateTime dataCriacao){
        this.dataCriacao = dataCriacao;
    }

    public Questionario getQuestionario(){
        return questionario;
    }

    public void setQuestionario(Questionario questionario){
        this.questionario = questionario;
    }

    public String getAluno(){
        return aluno;
    }

    public void setAluno(String aluno){
        this.aluno = aluno;
    }

    public String getProfessor(){
        return professor;
    }

    public void setProfessor(String professor){
        this.professor = professor;
    }

    public String getMateria(){
        return materia;
    }

    public void setMateria(String materia){
        this.materia = materia;
    }
    
}
