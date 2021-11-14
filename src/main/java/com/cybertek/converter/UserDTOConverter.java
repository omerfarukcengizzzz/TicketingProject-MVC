package com.cybertek.converter;

import com.cybertek.dto.UserDTO;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class UserDTOConverter implements Converter<String, UserDTO> {



    @Override
    public UserDTO convert(String source) {
        return null;
    }
}
