package br.univille.microservavaliacaoinstitucional.crud_questionario.entity;

import java.util.UUID;
import org.springframework.data.annotation.Id;
import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "alternativa", autoCreateContainer = true)
public class Alternativa {
    @Id
    @PartitionKey
    @GeneratedValue
    private String id;
    private String descricao;
    private boolean correto;

    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public boolean getCorreto(){
        return correto;
    }

    public void setCorreto(boolean correto){
        this.correto = correto;
    }
}
