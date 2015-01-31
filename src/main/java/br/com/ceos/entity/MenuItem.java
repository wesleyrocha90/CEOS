package br.com.ceos.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "MENU_ITEM")
@NamedQueries({
  @NamedQuery(name = "MenuItem.findAllByMenu", query = "SELECT m FROM MenuItem m WHERE m.pai = :pai ORDER BY m.ordem")
})
public class MenuItem implements Serializable {

  @Id
  @Column(name = "ID")
  private int id;

  @Column(name = "TITULO")
  private String titulo;

  @Column(name = "IMAGEM")
  private String imagem;

  @Column(name = "FXML_TELA")
  private String fxmlTela;

  @ManyToOne
  @JoinColumn(name = "FK_ID_MENU_PAINEL", referencedColumnName = "ID")
  private MenuPainel pai;

  @Column(name = "ORDEM")
  private int ordem;

  public MenuItem() {
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

  public String getImagem() {
    return imagem;
  }

  public void setImagem(String imagem) {
    this.imagem = imagem;
  }

  public String getFxmlTela() {
    return fxmlTela;
  }

  public void setFxmlTela(String fxmlTela) {
    this.fxmlTela = fxmlTela;
  }

  public MenuPainel getPai() {
    return pai;
  }

  public void setPai(MenuPainel pai) {
    this.pai = pai;
  }

  public int getOrdem() {
    return ordem;
  }

  public void setOrdem(int ordem) {
    this.ordem = ordem;
  }
}
