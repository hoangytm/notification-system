package com.hoangyth.configuration;

import com.hoangyth.utils.AccessoryTypeEnumConverter;
import com.hoangyth.utils.PermissionTypeEnumConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class CustomWebMvcConfigurationSupport extends WebMvcConfigurationSupport {
   @Override
   public FormattingConversionService mvcConversionService() {
       FormattingConversionService f = super.mvcConversionService();
       f.addConverter(new PermissionTypeEnumConverter());
       f.addConverter(new AccessoryTypeEnumConverter());
       return f;
   }
}