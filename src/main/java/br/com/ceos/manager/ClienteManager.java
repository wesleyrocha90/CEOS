package br.com.ceos.manager;

import br.com.ceos.entity.Cliente;
import br.com.ceos.util.QueryUtil;
import com.uaihebert.uaicriteria.UaiCriteria;
import java.util.List;

public class ClienteManager {

  public Cliente findByCnpjCpf(String cnpjCpf) {
    UaiCriteria<Cliente> criteria = QueryUtil.getCriteriaCliente();
    criteria.andEquals("cnpjCpf", cnpjCpf);
    return criteria.getSingleResult();
  }

  public List<Cliente> findByRazaoSocial(String razaoSocial) {
    UaiCriteria<Cliente> criteria = QueryUtil.getCriteriaCliente();
    criteria.andStringLike("razaoSocial", razaoSocial);
    return criteria.getResultList();
  }
  
  public List<Cliente> findAll() {
    UaiCriteria<Cliente> criteria = QueryUtil.getCriteriaCliente();
    return criteria.getResultList();
  }

}
