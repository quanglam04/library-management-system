package com.vn.commonService.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

@Configuration
public class MailConfig {
    @Primary
    @Bean
    public FreeMarkerConfigurationFactoryBean freeMarker() {
        FreeMarkerConfigurationFactoryBean freeMarkerConfiguration = new FreeMarkerConfigurationFactoryBean();
        freeMarkerConfiguration.setTemplateLoaderPath("classpath:/templates/");
        return freeMarkerConfiguration;

    }
}
