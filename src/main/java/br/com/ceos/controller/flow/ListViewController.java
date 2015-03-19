package br.com.ceos.controller.flow;

import br.com.ceos.util.BundleUtil;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class ListViewController {
  
  @Getter(AccessLevel.PUBLIC)
  @Setter(AccessLevel.PROTECTED)
  private StackPane container;
  
  private Parent rootList;
//  private AbstractListaController controllerList;
  private Parent rootEdit;
//  private AbstractCadastroController controllerEdit;
  
  /**
   * 
   * @param view O nome do arquivo .fxml que será a tela de listagem e edição,
   *  neste caso, apenas uma String porque o nome do arquivo é o mesmo
   */
  public ListViewController(String view){
    this(view, view);
  }
  
  /**
   * 
   * @param listView O nome do arquivo .fxml que será a tela de listagem
   * @param editView O nome do arquivo .fxml que será a tela de edição
   */
  public ListViewController(String listView, String editView){
    try {
      FXMLLoader loaderList = new FXMLLoader(getClass().getResource("/fxml/" + listView + "Lista.fxml"), BundleUtil.getBundle());
      rootList = (Parent) loaderList.load();
//      controllerList = loaderList.getController();
      FXMLLoader loaderEdit = new FXMLLoader(getClass().getResource("/fxml/" + listView + "Cadastro.fxml"), BundleUtil.getBundle());
      rootEdit = (Parent) loaderEdit.load();
//      controllerEdit = loaderEdit.getController();
      container = new StackPane(rootList);
    } catch (IOException ex) {
      System.out.println(ex);
    }
  }
  
  public void changeToEdit(){
    container.getChildren().clear();
    container.getChildren().add(rootEdit);
  }
  
  public void changeToList(){
    container.getChildren().clear();
    container.getChildren().add(rootList);
  }
}
