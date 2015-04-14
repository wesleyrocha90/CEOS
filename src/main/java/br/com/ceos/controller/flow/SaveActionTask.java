package br.com.ceos.controller.flow;

import br.com.ceos.entity.GrupoUsuario;
import br.com.ceos.util.QueryUtil;
import javax.inject.Inject;

public class SaveActionTask<E> implements Runnable{
  
  @Inject
  private DataModelFlow<GrupoUsuario> model;
  
  @Override
  public void run() {
    if(model.getEditedData() != null){
      if(model.getEditedData().getId() == null){
        QueryUtil.saveEntity(model.getEditedData());
      }else{
        QueryUtil.updateEntity(model.getEditedData());
      }
      model.getData().add(model.getEditedData());
    }
  }
}
