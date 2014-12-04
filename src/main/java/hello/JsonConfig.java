package hello;

import static com.fasterxml.jackson.databind.SerializationFeature.INDENT_OUTPUT;
import static org.kuali.common.core.json.jackson.ObjectMappers.buildDefaultMapper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class JsonConfig {

    @Bean
    public MappingJackson2HttpMessageConverter jacksonConverter() {
        ObjectMapper mapper = buildDefaultMapper();
        mapper.configure(INDENT_OUTPUT, true); // this is a synonym for 'pretty print'
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(mapper);
        return converter;
    }

}