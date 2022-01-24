package com.citybank.persons.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@Data
@ConstructorBinding
@ConfigurationProperties(prefix = "postgres")
public class PostgresConfigProperties {

    private String host;
    private Integer port;
    private String database;
    private String schema;
    private String username;
    private String password;

}
