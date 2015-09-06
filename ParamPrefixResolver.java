package com.supwisdom.eams.infras.springmvc;

import org.springframework.beans.BeanUtils;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.ModelFactory;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.ServletRequest;
import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * Created by hanwen on 15-9-2.
 */
public class ParamPrefixResolver implements HandlerMethodArgumentResolver {

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    return parameter.getParameterAnnotation(ParamPrefix.class) != null;
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {

    String name = ModelFactory.getNameForParameter(parameter);
    Object attribute = (mavContainer.containsAttribute(name) ?
        mavContainer.getModel().get(name) : BeanUtils.instantiateClass(parameter.getParameterType()));

    WebDataBinder binder = new ParamPrefixDataBinder(attribute, name, parameter.getParameterAnnotation(ParamPrefix.class).value());

    if (binder.getTarget() != null) {
      bindRequestParameters(binder, webRequest);
      validateIfApplicable(binder, parameter);
      if (binder.getBindingResult().hasErrors() && isBindExceptionRequired(parameter)) {
        throw new BindException(binder.getBindingResult());
      }
    }

    // Add resolved attribute and BindingResult at the end of the model
    Map<String, Object> bindingResultModel = binder.getBindingResult().getModel();
    mavContainer.removeAttributes(bindingResultModel);
    mavContainer.addAllAttributes(bindingResultModel);

    return binder.convertIfNecessary(binder.getTarget(), parameter.getParameterType(), parameter);
  }

  protected void bindRequestParameters(WebDataBinder binder, NativeWebRequest request) {
    ServletRequest servletRequest = request.getNativeRequest(ServletRequest.class);
    ServletRequestDataBinder servletBinder = (ServletRequestDataBinder) binder;
    servletBinder.bind(servletRequest);
  }

  protected void validateIfApplicable(WebDataBinder binder, MethodParameter methodParam) {
    Annotation[] annotations = methodParam.getParameterAnnotations();
    for (Annotation ann : annotations) {
      Validated validatedAnn = AnnotationUtils.getAnnotation(ann, Validated.class);
      if (validatedAnn != null || ann.annotationType().getSimpleName().startsWith("Valid")) {
        Object hints = (validatedAnn != null ? validatedAnn.value() : AnnotationUtils.getValue(ann));
        Object[] validationHints = (hints instanceof Object[] ? (Object[]) hints : new Object[] {hints});
        binder.validate(validationHints);
        break;
      }
    }
  }

  protected boolean isBindExceptionRequired(MethodParameter methodParam) {
    int i = methodParam.getParameterIndex();
    Class<?>[] paramTypes = methodParam.getMethod().getParameterTypes();
    boolean hasBindingResult = (paramTypes.length > (i + 1) && Errors.class.isAssignableFrom(paramTypes[i + 1]));
    return !hasBindingResult;
  }

}
