package br.univille.microservavaliacaoinstitucional.crud_questionario.entity;

import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "pergunta", autoCreateContainer = true)
public class Pergunta {
    @Id
    @PartitionKey
    @GeneratedValue
    private String id;
    private String titulo;
    private List<Alternativa> alternativas;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }
    
}
