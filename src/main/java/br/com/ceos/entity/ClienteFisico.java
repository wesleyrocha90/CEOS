package br.com.ceos.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Embeddable
public class ClienteFisico extends Cliente implements Serializable {
  
  @Column(name = "CPF")
  @Getter @Setter private String cpf;
  
  @Column(name = "NOME")
  @Getter @Setter private String nome;
}
