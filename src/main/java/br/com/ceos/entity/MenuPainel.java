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
@Table(name = "MENU_PAINEL")
@NamedQueries({
  @NamedQuery(name = "MenuPainel.findAll", query = "SELECT m FROM MenuPainel m ORDER BY m.ordem")
})
@NoArgsConstructor
public class MenuPainel implements Serializable {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter @Setter private Long id;

  @Column(name = "TITULO")
  @Getter @Setter private String titulo;

  @Column(name = "ORDEM")
  @Getter @Setter private Integer ordem;
}
