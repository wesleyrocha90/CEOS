package br.com.ceos.entity;

import br.com.ceos.convert.LocalDatePersistenceConverter;
import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
public class Usuario extends EntidadeBase implements Serializable {

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

  @Column(name = "DATA_EXPIRACAO")
  @Convert(converter = LocalDatePersistenceConverter.class)
  @Future
  @Getter @Setter private LocalDate dataExpiracao;
}
