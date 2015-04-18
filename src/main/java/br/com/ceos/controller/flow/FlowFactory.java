package br.com.ceos.controller.flow;

import br.com.ceos.util.BundleUtil;
import io.datafx.controller.ViewConfiguration;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.action.FlowActionChain;
import io.datafx.controller.flow.action.FlowLink;
import io.datafx.controller.flow.action.FlowMethodAction;
import io.datafx.controller.flow.action.FlowTaskAction;

public class FlowFactory {
  
  public static Flow createFlow(String nomeDasClasses){
    try {
      Class<?> classeLista = Class.forName("br.com.ceos.controller." + nomeDasClasses + "ListaController");
      Class<?> classeCadastro = Class.forName("br.com.ceos.controller." + nomeDasClasses + "CadastroController");
      
      ViewConfiguration viewConfiguration = new ViewConfiguration();
      viewConfiguration.setResources(BundleUtil.getBundle());
      Flow flow = new FlowI18n(classeLista, viewConfiguration)
          .withLink(classeLista, "editar", classeCadastro)
          .withAction(classeLista, "criar", new FlowActionChain(
              new FlowMethodAction(classeLista.getMethod("onBotaoCriarNovoAction")),
              new FlowLink(classeCadastro)))
          .withTaskAction(classeLista, "remover", RemoveActionTask.class)
          .withAction(classeCadastro, "salvar", new FlowActionChain(
              new FlowMethodAction(classeCadastro.getMethod("onSaveAction")),
              new FlowTaskAction(SaveActionTask.class)))
          .withAction(classeCadastro, "salvarEFechar", new FlowActionChain(
              new FlowMethodAction(classeCadastro.getMethod("onSaveAction")),
              new FlowTaskAction(SaveActionTask.class),
              new FlowLink(classeLista)))
          .withLink(classeCadastro, "cancelar", classeLista);
      return flow;
      
    } catch (ClassNotFoundException | NoSuchMethodException ex) {
      System.out.println(ex);
    }
    return null;
  }
}
