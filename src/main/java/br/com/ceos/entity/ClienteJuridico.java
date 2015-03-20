package br.com.ceos.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CLIENTE_JURIDICO")
public class ClienteJuridico extends Cliente implements Serializable {

  @Column(name = "RAZAO_SOCIAL")
  @Getter @Setter private String razaoSocial;

  @Column(name = "NOME_FANTASIA")
  @Getter @Setter private String nomeFantasia;

  @Column(name = "CNPJ", unique = true)
  @Getter @Setter private String cnpj;

  @Column(name = "IE")
  @Getter @Setter private String inscricaoEstadual;

  @Column(name = "IM")
  @Getter @Setter private String inscricaoMunicipal;
}
