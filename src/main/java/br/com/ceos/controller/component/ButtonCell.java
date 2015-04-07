package br.com.ceos.controller.component;

import br.com.ceos.entity.GrupoUsuario;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.image.ImageView;

public class ButtonCell extends TableCell<GrupoUsuario, Boolean>{
  final Button cellButton = new Button();
  
  public ButtonCell(String nomeIcone){
    cellButton.setGraphic(new ImageView(getClass().getResource("/icons/" + nomeIcone + ".png").toString()));
    cellButton.setStyle("-fx-background-color: transparent;");
    cellButton.setOnAction( event -> {
      System.out.println("Hello World !");
    });
  }
  
  @Override
  protected void updateItem(Boolean t, boolean empty){
    super.updateItem(t, empty);
    if(!empty){
      setGraphic(cellButton);
    }
  }
}
