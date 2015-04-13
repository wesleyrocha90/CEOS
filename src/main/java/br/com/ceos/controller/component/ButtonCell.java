package br.com.ceos.controller.component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.image.ImageView;

public class ButtonCell<E> extends TableCell<E, Boolean>{
  final Button cellButton = new Button();
  
  public ButtonCell(String nomeIcone, EventHandler<ActionEvent> event){
    cellButton.setGraphic(new ImageView(getClass().getResource("/icons/" + nomeIcone + ".png").toString()));
    cellButton.setStyle("-fx-background-color: transparent;");
    cellButton.setOnAction(event);
  }
  
  @Override
  protected void updateItem(Boolean t, boolean empty){
    super.updateItem(t, empty);
    if(!empty){
      setGraphic(cellButton);
    }
  }
}
