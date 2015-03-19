package br.com.ceos.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ENDERECO")
public class Endereco extends EntidadeBase implements Serializable {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ENDERECO_ID")
    @Getter @Setter private Long id;
  
    @Column(name = "LOGRADOURO")
    @Getter @Setter private String logradouro;
    
    @Column(name = "COMPLEMENTO")
    @Getter @Setter private String complemento;
    
    @Column(name = "NUMERO")
    @Getter @Setter private String numero;
    
    @Column(name = "BAIRRO")
    @Getter @Setter private String bairro;
    
    @Column(name = "MUNICIPIO")
    @Getter @Setter private String municipio;
    
    @Column(name = "UF")
    @Getter @Setter private String uf;
  
}
