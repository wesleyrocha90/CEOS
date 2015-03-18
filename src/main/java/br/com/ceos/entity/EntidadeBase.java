package br.com.ceos.entity;

import br.com.ceos.convert.LocalDatePersistenceConverter;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@AllArgsConstructor
public class EntidadeBase {

  @Column(name = "DATA_CRIACAO")
  @Convert(converter = LocalDatePersistenceConverter.class)
  @Getter @Setter private LocalDate dataCriacao;

  @Column(name = "DATA_ALTERACAO")
  @Convert(converter = LocalDatePersistenceConverter.class)
  @Getter @Setter private LocalDate dataAlteracao;

  @OneToOne
  @JoinColumn(name = "FK_ID_USUARIO_ALTERACAO", referencedColumnName = "ID")
  @Getter @Setter private Usuario usuarioAlteracao;

  @Column(name = "DATA_EXCLUSAO")
  @Convert(converter = LocalDatePersistenceConverter.class)
  @Getter @Setter private LocalDate dataExclusao;

  @OneToOne
  @JoinColumn(name = "FK_ID_USUARIO_EXCLUSAO", referencedColumnName = "ID")
  @Getter @Setter private Usuario usuarioExclusao;
  
  public EntidadeBase() {
    dataCriacao = LocalDate.now();
  }
}
