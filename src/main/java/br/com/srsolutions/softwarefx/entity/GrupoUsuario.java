package br.com.srsolutions.softwarefx.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "GRUPO_USUARIO")
public class GrupoUsuario implements Serializable {
  
  private static final String SEQUENCE = "SEQ_GRUPO_USUARIO_ID";
  
  @Id
  @Column(name = "ID")
  @SequenceGenerator(name = GrupoUsuario.SEQUENCE, sequenceName = GrupoUsuario.SEQUENCE, allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
  private int id;
  
  @Column(name = "DESCRICAO")
  private String descricao;
  
  @Column(name = "DATA_CADASTRO")
  @Temporal(TemporalType.DATE)
  private Date dataCadasatro;

  public GrupoUsuario() {
  }

  public GrupoUsuario(String descricao, Date dataCadasatro) {
    this.descricao = descricao;
    this.dataCadasatro = dataCadasatro;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public Date getDataCadasatro() {
    return dataCadasatro;
  }

  public void setDataCadasatro(Date dataCadasatro) {
    this.dataCadasatro = dataCadasatro;
  }
}
