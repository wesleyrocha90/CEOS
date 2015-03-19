package br.com.ceos.controller.flow;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ObservableList;
import lombok.NonNull;

public class ListViewDataModel<E> {
  
  private ObservableList<E> dados;
  private IntegerProperty indiceDadoSelecionado;
  
  public ObservableList<E> getDados(){
    return dados;
  }
  
  public void setDados(@NonNull ObservableList<E> dados){
    this.dados = dados;
  }
  
  public IntegerProperty indiceDadoSelecionadoProperty(){
    if(indiceDadoSelecionado == null){
      indiceDadoSelecionado = new SimpleIntegerProperty(-1);
    }
    return indiceDadoSelecionado; 
  }
  
  public int getIndiceDadoSelecionado(){
    return indiceDadoSelecionadoProperty().get();
  }
  
  public void setIndiceDadoSelecionado(int indiceDadoSelecionado){
    indiceDadoSelecionadoProperty().set(indiceDadoSelecionado);
  }
}
