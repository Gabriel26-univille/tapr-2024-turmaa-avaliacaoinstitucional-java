package br.univille.microservavaliacaoinstitucional.crud_questionario.entity;

import java.util.UUID;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "questionario", autoCreateContainer = true)
public class Questionario {
    @Id
    @PartitionKey
    @GeneratedValue
    private String id;
    private String nome;
    private LocalDateTime dataCriacao;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public LocalDateTime getdataCriacao(){
        return dataCriacao;
    }

    public void setdataCriacao(LocalDateTime dataCriacao){
        this.dataCriacao = dataCriacao;
    }
}
