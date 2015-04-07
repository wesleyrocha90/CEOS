package br.com.ceos.controller.flow;

import br.com.ceos.util.QueryUtil;
import javax.inject.Inject;

public class SaveActionTask implements Runnable{
  
  @Inject
  private DataModelFlow model;
  
  @Override
  public void run() {
    if(model.getEditedData() != null){
      if(model.getEditedData().getId() > 0){
        QueryUtil.updateEntity(model.getEditedData());
      }else{
        QueryUtil.saveEntity(model.getEditedData());
      }
      model.getData().add(model.getEditedData());
    }
  }
}
