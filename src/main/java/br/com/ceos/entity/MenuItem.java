package br.com.ceos.entity;

import java.io.Serializable;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "MENU_ITEM")
@NamedQueries({
  @NamedQuery(name = "MenuItem.findAllByMenu", query = "SELECT m FROM MenuItem m WHERE m.pai = :pai ORDER BY m.ordem")
})
@NoArgsConstructor
public class MenuItem implements Serializable {

  @Id
  @Column(name = "ID")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter @Setter private Long id;

  @Column(name = "TITULO")
  @Getter @Setter private String titulo;

  @Column(name = "IMAGEM")
  @Getter @Setter private String imagem;

  @Column(name = "CLASSE_CONTROLLER")
  @Getter @Setter private String fxmlTela;

  @ManyToOne
  @JoinColumn(name = "FK_ID_MENU_PAINEL", referencedColumnName = "ID")
  @Getter @Setter private MenuPainel pai;

  @Column(name = "ORDEM")
  @Getter @Setter private Integer ordem;
}
