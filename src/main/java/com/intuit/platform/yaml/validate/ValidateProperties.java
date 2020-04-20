package com.intuit.platform.yaml.validate;

import org.springframework.beans.factory.config.YamlProcessor;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
@Configuration
public class ValidateProperties {
  public String check() {
    YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
    factory.setResolutionMethod(YamlProcessor.ResolutionMethod.OVERRIDE);
    factory.setResources(new FileSystemResource("/Users/jagarwal/projects/config2/test-yaml/src/main/resources/test.yaml"));
    factory.setSingleton(true);
    factory.afterPropertiesSet();
    Map<Object, Object> properties = factory.getObject();
    StringBuffer sb = new StringBuffer();
    for (Map.Entry<Object, Object> entry : properties.entrySet()) {
      sb.append( entry.getKey() + ":" + entry.getValue().toString()+" {valueInstanceOf="+entry.getValue().getClass()+"}"+"\n\n");
    }
    return sb.toString();
  }
}
