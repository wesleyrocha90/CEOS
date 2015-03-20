package br.com.ceos.controller.flow;

import org.datafx.controller.ViewConfiguration;
import org.datafx.controller.flow.Flow;
import org.datafx.controller.flow.FlowHandler;
import org.datafx.controller.flow.context.ViewFlowContext;

/**
 * Classe usada para configurar o recurso da internacionalização no FlowAPI
 */
public class FlowI18n extends Flow{
  
  ViewConfiguration viewConfiguration;
  
  public FlowI18n(Class<?> startViewControllerClass, ViewConfiguration viewConfiguration) {
    super(startViewControllerClass);
    this.viewConfiguration = viewConfiguration;
  }

  @Override
  public FlowHandler createHandler(ViewFlowContext flowContext) {
    return new FlowHandlerI18n(this, flowContext, viewConfiguration);
  }
}
