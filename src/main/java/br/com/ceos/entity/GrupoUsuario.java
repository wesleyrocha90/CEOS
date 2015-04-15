package br.com.ceos.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "GRUPO_USUARIO")
@NamedQueries({
  @NamedQuery(name = "GrupoUsuario.findAll", query = "SELECT g FROM GrupoUsuario g")
})
@NoArgsConstructor
public class GrupoUsuario extends EntidadeBase implements Serializable {

  @Column(name = "DESCRICAO")
  @Getter @Setter private String descricao;
}
