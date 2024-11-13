package com.example.projectInterbankclientes.config;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {



    @Bean("roleMapper")
    public ModelMapper roleMapper(){
        return new ModelMapper();
    }

    @Bean("userMapper")
    public ModelMapper userMapper(){
        return new ModelMapper();
    }

}
