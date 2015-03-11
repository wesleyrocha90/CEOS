package br.com.ceos.entity;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USUARIO")
@NamedQueries({
  @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u ORDER BY u.login"),
  @NamedQuery(name = "Usuario.findAllByNome", query = "SELECT u FROM Usuario u WHERE u.login = :login"),
  @NamedQuery(name = "Usuario.findByLoginSenha", query = "SELECT u FROM Usuario u WHERE u.login = :login AND u.senha = :senha")
})
@NoArgsConstructor
public class Usuario implements Serializable {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter @Setter private int id;

  @Column(name = "LOGIN")
  @NotNull
  @Getter @Setter private String login;

  @Column(name = "SENHA")
  @NotNull
  @Getter @Setter private String senha;

  @Column(name = "ATIVO")
  @Getter @Setter private boolean ativo;

  @ManyToOne
  @JoinColumn(name = "FK_GRUPO_USUARIO_ID", referencedColumnName = "ID")
  @Getter @Setter private GrupoUsuario grupoUsuario;

  @Column(name = "DATA_CADASTRO")
  @Temporal(TemporalType.DATE)
  @Getter @Setter private Date dataCadastro;

  @Column(name = "DATA_EXPIRACAO")
  @Temporal(TemporalType.DATE)
  @Future
  @Getter @Setter private Date dataExpiração;

  public Usuario(String login, String senha, boolean ativo, GrupoUsuario grupoUsuario, Date dataCadastro, Date dataExpiração) {
    this.login = login;
    this.senha = senha;
    this.ativo = ativo;
    this.grupoUsuario = grupoUsuario;
    this.dataCadastro = dataCadastro;
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
