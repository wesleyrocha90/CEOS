package br.com.ceos.controller.flow;

import org.datafx.controller.ViewConfiguration;
import org.datafx.controller.flow.Flow;
import org.datafx.controller.flow.FlowHandler;
import org.datafx.controller.flow.context.ViewFlowContext;

/**
 * Classe usada para configurar o recurso da internacionalização no FlowAPI
 */
public class FlowHandlerI18n extends FlowHandler{

  public FlowHandlerI18n(Flow flow, ViewFlowContext flowContext, ViewConfiguration viewConfiguration) {
    super(flow, flowContext, viewConfiguration);
  }
}
