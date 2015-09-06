package com.supwisdom.eams.infras.springmvc;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.web.bind.ServletRequestDataBinder;

import javax.servlet.ServletRequest;

/**
 * Created by hanwen on 15-9-2.
 */
public class ParamPrefixDataBinder extends ServletRequestDataBinder {

  private static final String DOT = ".";

  private String prefix;

  public ParamPrefixDataBinder(Object target, String objectName, String prefix) {
    super(target, objectName);
    this.prefix = prefix;
  }

  @Override
  protected void addBindValues(MutablePropertyValues mpvs, ServletRequest request) {
    for (PropertyValue propertyValue : mpvs.getPropertyValues()) {
      if (propertyValue.getName().toLowerCase().indexOf(prefix.toLowerCase()) != -1) {
        mpvs.add(propertyValue.getName().substring(propertyValue.getName().indexOf(DOT) + 1), propertyValue.getValue());
        mpvs.removePropertyValue(propertyValue.getName());
      }
    }
  }
}
