package com.example.demo.util;

import com.example.demo.dto.ProfileDTO;
import com.example.demo.entity.Profile;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-20T14:35:18+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 1.8.0_171 (Oracle Corporation)"
)
@Component
public class ProfileMapperImpl implements ProfileMapper {

    @Override
    public void updateCustomerFromDto(ProfileDTO dto, Profile entity) {
        if ( dto == null ) {
            return;
        }
    }
}
