package br.com.ceos.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "MENU_PAINEL")
@NamedQueries({
  @NamedQuery(name = "MenuPainel.findAll", query = "SELECT m FROM MenuPainel m ORDER BY m.ordem")
})
public class MenuPainel implements Serializable {

  @Id
  @Column(name = "ID")
  private int id;

  @Column(name = "TITULO")
  private String titulo;

  @Column(name = "ORDEM")
  private int ordem;

  public MenuPainel() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public int getOrdem() {
    return ordem;
  }

  public void setOrdem(int ordem) {
    this.ordem = ordem;
  }
}
