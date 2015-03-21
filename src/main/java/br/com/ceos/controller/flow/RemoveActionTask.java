package br.com.ceos.controller.flow;

import br.com.ceos.util.QueryUtil;
import javax.inject.Inject;

public class RemoveActionTask implements Runnable {
  
  @Inject
  private DataModelFlow model;
  
  @Override
  public void run() {
    if(model.getSelectedDataIndex() >= 0){
      QueryUtil.removeEntity(model.getData().get(model.getSelectedDataIndex()));
      model.getData().remove(model.getData().get(model.getSelectedDataIndex()));
    }
  }
}
