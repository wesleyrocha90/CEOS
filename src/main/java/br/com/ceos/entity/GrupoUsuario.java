package br.com.ceos.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "GRUPO_USUARIO")
@NoArgsConstructor
public class GrupoUsuario implements Serializable {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter @Setter private int id;

  @Column(name = "DESCRICAO")
  @Getter @Setter private String descricao;

  @Column(name = "DATA_CADASTRO")
  @Temporal(TemporalType.DATE)
  @Getter @Setter private Date dataCadasatro;

  public GrupoUsuario(String descricao, Date dataCadasatro) {
    this.descricao = descricao;
    this.dataCadasatro = dataCadasatro;
  }
}
