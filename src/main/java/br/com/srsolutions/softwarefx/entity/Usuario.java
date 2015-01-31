package br.com.srsolutions.softwarefx.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "USUARIO")
@NamedQueries({
  @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u ORDER BY u.login"),
  @NamedQuery(name = "Usuario.findAllByNome", query = "SELECT u FROM Usuario u WHERE u.login = :login"),
  @NamedQuery(name = "Usuario.findByLoginSenha", query = "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha")
})
public class Usuario implements Serializable {

  private static final String SEQUENCE = "SEQ_USUARIO_ID";

  @Id
  @Column(name = "ID")
  @SequenceGenerator(name = Usuario.SEQUENCE, sequenceName = Usuario.SEQUENCE, allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE)
  private int id;

  @Column(name = "LOGIN")
  @NotNull
  private String login;

  @Column(name = "SENHA")
  @NotNull
  private String senha;

  @Column(name = "ATIVO")
  private boolean ativo;

  @ManyToOne
  @JoinColumn(name = "FK_GRUPO_USUARIO_ID", referencedColumnName = "ID")
  private GrupoUsuario grupoUsuario;

  @Column(name = "DATA_CADASTRO")
  @Temporal(TemporalType.DATE)
  private Date dataCadastro;

  @Column(name = "DATA_EXPIRACAO")
  @Temporal(TemporalType.DATE)
  @Future
  private Date dataExpiração;

  public Usuario() {
  }

  public Usuario(String login, String senha, boolean ativo, GrupoUsuario grupoUsuario, Date dataCadastro, Date dataExpiração) {
    this.login = login;
    this.senha = senha;
    this.ativo = ativo;
    this.grupoUsuario = grupoUsuario;
    this.dataCadastro = dataCadastro;
    this.dataExpiração = dataExpiração;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public boolean isAtivo() {
    return ativo;
  }

  public void setAtivo(boolean ativo) {
    this.ativo = ativo;
  }

  public GrupoUsuario getGrupoUsuario() {
    return grupoUsuario;
  }

  public void setGrupoUsuario(GrupoUsuario grupoUsuario) {
    this.grupoUsuario = grupoUsuario;
  }

  public Date getDataCadastro() {
    return dataCadastro;
  }

  public void setDataCadastro(Date dataCadastro) {
    this.dataCadastro = dataCadastro;
  }

  public Date getDataExpiração() {
    return dataExpiração;
  }

  public void setDataExpiração(Date dataExpiração) {
    this.dataExpiração = dataExpiração;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("USUARIO[");
    s.append("id:").append(id);
    s.append(",login:").append(login);
    s.append(",senha:").append(senha);
    s.append(",ativo:").append(ativo);
    s.append(",grupoUsuario").append(grupoUsuario);
    s.append(",dataCadastro:").append(dataCadastro);
    s.append(",dataExpiração:").append(dataExpiração);
    s.append("]");
    return s.toString();
  }
}
