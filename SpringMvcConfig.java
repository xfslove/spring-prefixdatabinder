package com.supwisdom.eams.infras.springmvc;

import com.supwisdom.eams.infras.convert.StringToAssocConverterFactory;
import com.supwisdom.eams.infras.convert.StringToQueryPageConverterFactory;
import com.supwisdom.eams.infras.convert.StringToSortConverterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import java.util.List;

/**
 * Created by hanwen on 15-9-2.
 */
@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
    argumentResolvers.add(new ParamPrefixResolver());
    super.addArgumentResolvers(argumentResolvers);
  }

}
