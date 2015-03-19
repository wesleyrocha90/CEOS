package br.com.ceos.controller.flow;

import br.com.ceos.util.BundleUtil;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javax.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class ListViewController {
  
  @Getter(AccessLevel.PUBLIC)
  @Setter(AccessLevel.PROTECTED)
  private StackPane container;
  
  private Parent rootList;
  private AbstractListaController controllerList;
  private Parent rootEdit;
  private AbstractCadastroController controllerEdit;
  
  public ListViewController(String view){
    this(view, view);
  }
  
  public ListViewController(String listView, String editView){
    try {
      FXMLLoader loaderList = new FXMLLoader(getClass().getResource("/fxml/" + listView + "Lista.fxml"), BundleUtil.getBundle());
      rootList = (Parent) loaderList.load();
      controllerList = loaderList.getController();
      FXMLLoader loaderEdit = new FXMLLoader(getClass().getResource("/fxml/" + listView + "Cadastro.fxml"), BundleUtil.getBundle());
      rootEdit = (Parent) loaderEdit.load();
      controllerEdit = loaderEdit.getController();
      container = new StackPane(rootList);
      setThisToControllers();
    } catch (IOException ex) {
      System.out.println(ex);
    }
  }
  
  private void setThisToControllers(){
    controllerList.setController(this);
    controllerEdit.setController(this);
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
