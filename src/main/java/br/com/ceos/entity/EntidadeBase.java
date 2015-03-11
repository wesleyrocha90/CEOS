package br.com.ceos.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class EntidadeBase {

  @Column(name = "DATA_CRIACAO")
  @Temporal(TemporalType.DATE)
  @Getter @Setter private Date dataCriacao;

  @Column(name = "DATA_ALTERACAO")
  @Temporal(TemporalType.DATE)
  @Getter @Setter private Date dataAlteracao;

  @OneToOne
  @JoinColumn(name = "FK_ID_USUARIO_ALTERACAO", referencedColumnName = "ID")
  @Getter @Setter private Usuario usuarioAlteracao;

  @Column(name = "DATA_EXCLUSAO")
  @Temporal(TemporalType.DATE)
  @Getter @Setter private Date dataExclusao;

  @OneToOne
  @JoinColumn(name = "FK_ID_USUARIO_EXCLUSAO", referencedColumnName = "ID")
  @Getter @Setter private Usuario usuarioExclusao;
}
