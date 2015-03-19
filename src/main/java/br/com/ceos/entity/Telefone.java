
package br.com.ceos.entity;

import br.com.ceos.entity.enumerations.TipoTelefone;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TELEFONE")
public class Telefone extends EntidadeBase implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "TELEFONE_ID")
  @Getter @Setter private Long id;
  
  @Column(name = "DDD")
  @Getter @Setter private Short ddd;
  
  @Column(name = "CELULAR")
  @Getter @Setter private Long numero;
  
  @Enumerated(EnumType.ORDINAL)
  @Column(name = "TIPO")
  @Getter @Setter private TipoTelefone tipo;
}
