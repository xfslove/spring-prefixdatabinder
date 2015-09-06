package com.supwisdom.eams.infras.springmvc;

import java.lang.annotation.*;

/**
 * Created by hanwen on 15-9-2.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamPrefix {

  /**
   * prefix
   * @return
   */
  String value() default "";
}
