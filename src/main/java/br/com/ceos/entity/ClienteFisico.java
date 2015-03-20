package br.com.ceos.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CLIENTE_FISICO")
public class ClienteFisico extends Cliente implements Serializable {
  
  @Column(name = "CPF")
  @Getter @Setter private String cpf;
  
  @Column(name = "NOME")
  @Getter @Setter private String nome;
}
