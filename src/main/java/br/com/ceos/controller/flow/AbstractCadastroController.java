package br.com.ceos.controller.flow;

import br.com.ceos.entity.EntidadeBase;
import io.datafx.controller.flow.action.ActionTrigger;
import java.lang.reflect.ParameterizedType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import lombok.Getter;

public abstract class AbstractCadastroController<E extends EntidadeBase> {

  @FXML
  @ActionTrigger("salvar")
  private Button salvar;
  
  @FXML
  @ActionTrigger("salvarEFechar")
  private Button salvarEFechar;
  
  @FXML
  @ActionTrigger("cancelar")
  private Button cancelar;
  
  @Inject
  @Getter private DataModelFlow<E> modelo;
  
  public abstract void telaParaObjeto(E objeto);
  public abstract void objetoParaTela(E objeto);
  
  public void onSaveAction(){
    telaParaObjeto(modelo.getDado());
  }
  
  @PostConstruct
  public void initialize(){
    if(modelo != null){
      if(modelo.getIndiceDado() >= 0){
        modelo.setDado(modelo.getDados().get(modelo.getIndiceDado()));
      }else{
        try {
          ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
          String parameterClassName = parameterizedType.getActualTypeArguments()[0].getTypeName();
          modelo.setDado((E) Class.forName(parameterClassName).newInstance());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
          System.out.println(ex);
        }
      }
      objetoParaTela(modelo.getDado());
    }
  }
}
