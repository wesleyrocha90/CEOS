package br.com.ceos.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter @Setter private Long id;

  @Column(name = "DESCRICAO")
  @Getter @Setter private String descricao;

  public GrupoUsuario(String descricao) {
    this.descricao = descricao;
  }
  
  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("GRUPO USUARIO[");
    s.append("id:").append(id);
    s.append(",descricao:").append(descricao);
    s.append("]");
    return s.toString();
  }
}
