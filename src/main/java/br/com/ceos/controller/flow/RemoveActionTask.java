package br.com.ceos.controller.flow;

import br.com.ceos.util.QueryUtil;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javax.inject.Inject;

public class RemoveActionTask implements Runnable {
  
  @Inject
  private DataModelFlow model;
  
  @Override
  public void run() {
    if(model.getSelectedDataIndex() >= 0){    
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Confirma exclusão");
      alert.setHeaderText(null);
      alert.setContentText("Tem certeza que deseja excluir o item selecionado ?");

      Optional<ButtonType> result = alert.showAndWait();
      if(result.get() == ButtonType.OK){
        QueryUtil.removeEntity(model.getData().get(model.getSelectedDataIndex()));
        model.getData().remove(model.getData().get(model.getSelectedDataIndex()));
      }
    }
  }
}
