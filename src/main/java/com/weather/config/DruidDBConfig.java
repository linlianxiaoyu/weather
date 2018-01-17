package com.weather.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
public class DruidDBConfig {

    private Logger logger = LoggerFactory.getLogger(DruidDBConfig.class);

    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driverClassName}")
    private String driverClassName;

    @Value("${spring.datasource.initialSize}")
    private int initialSize;

    @Value("${spring.datasource.minIdle}")
    private int minIdle;

    @Value("${spring.datasource.maxActive}")
    private int maxActive;

    @Value("${spring.datasource.maxWait}")
    private int maxWait;

    @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${spring.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${spring.datasource.validationQuery}")
    private String validationQuery;

    @Value("${spring.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${spring.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${spring.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${spring.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${spring.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${spring.datasource.filters}")
    private  String filters;

    @Value("{spring.datasource.connectionProperties}")
    private String connectionProperties;


    @Bean
    @Primary
    public DataSource dataSource () {

        DruidDataSource dataSource = new DruidDataSource();

        dataSource.setUrl(this.dbUrl);

        dataSource.setUsername(this.username);

        dataSource.setPassword(this.password);

        dataSource.setDriverClassName(this.driverClassName);

        dataSource.setInitialSize(this.initialSize);
        dataSource.setMinIdle(this.minIdle);
        dataSource.setMaxActive(this.maxActive);
        dataSource.setMaxWait(this.maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(this.timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(this.minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(this.validationQuery);
        dataSource.setTestWhileIdle(this.testWhileIdle);
        dataSource.setTestOnBorrow(this.testOnBorrow);
        dataSource.setTestOnReturn(this.testOnReturn);
        dataSource.setPoolPreparedStatements(this.poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(this.maxPoolPreparedStatementPerConnectionSize);

        try{
            dataSource.setFilters(this.filters);
        }catch (SQLException e){
            logger.error("druid configuration initialization filter", e);
        }

        dataSource.setConnectProperties(getProperties(this.connectionProperties));

        return dataSource;

    }


    private Properties getProperties (String stringProperties) {

        Properties properties = new Properties();

        String[] propertieWithEqual = stringProperties.split(";");

        try{

            for(String s : propertieWithEqual){

                String[] attr = s.split("=");

                String key = attr[0];
                String value = attr[1];

                properties.setProperty(key,value);

            }

        }catch(Exception e){

            throw new RuntimeException("Parse Properties Exception ! ");

        }

        return properties;

    }


}
