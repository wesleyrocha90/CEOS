package br.com.ceos.util;

import br.com.ceos.entity.exceptions.ValidateException;
import java.util.Iterator;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

public class EntidadeValidator {

  public static void validarDTO(Object obj) throws ValidateException {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    javax.validation.Validator validator = factory.getValidator();
    Set<ConstraintViolation<Object>> errors = validator.validate(obj);
    Iterator<ConstraintViolation<Object>> it = errors.iterator();
    while (it.hasNext()) {
      ConstraintViolation error = it.next();
      throw new ValidateException(error.getMessage());
    }
  }
}
