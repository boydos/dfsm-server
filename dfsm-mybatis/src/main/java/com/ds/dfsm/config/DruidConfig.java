package com.ds.dfsm.config;

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
public class DruidConfig {

    private static Logger logger = LoggerFactory.getLogger(DruidConfig.class);

    @Value("${spring.datasource.driver-class-name:}")
    private String driverClassName;

    @Value("${spring.datasource.url:}")
    private String jdbcUrl;

    @Value("${spring.datasource.username:}")
    private String userName;

    @Value("${spring.datasource.password:}")
    private String password;

    //customer config

    @Value("${druid.initial-size:0}")
    private int initialSize;

    @Value("${druid.max-active:8}")
    private int maxActive;

    @Value("${druid.min-idle:0}")
    private int minIdle;

    @Value("${druid.max-wait:-1}")
    private long maxWait;

    @Value("${druid.time-between-eviction-runs-millis:60000}")
    private long timeBetweenEvictionRunsMillis;

    @Value("${druid.min-evictable-idle-time-millis:1800000}")
    private long minEvictableIdleTimeMillis;

    @Value("${druid.validation-query:}")
    private String validationQuery;

    @Value("${druid.test-while-idle:true}")
    private boolean testWhileIdle;

    @Value("${druid.test-on-borrow:false}")
    private boolean testOnBorrow;

    @Value("${druid.test-on-return:false}")
    private boolean testOnReturn;

    @Value("${druid.max-pool-perconnection-size:10}")
    private int maxPoolPerConnectionSize;

    @Value("${druid.pool-prepared-statements:false}")
    private boolean poolPreparedStatements;

    @Value("${druid.filters:}")
    private String filters;

    @Value("${druid.connection-properties:}")
    private Properties connectionProperties;


    @Bean
    @Primary
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(jdbcUrl);
        druidDataSource.setUsername(userName);
        druidDataSource.setPassword(password);

        druidDataSource.setInitialSize(initialSize);
        druidDataSource.setMaxActive(maxActive);
        druidDataSource.setMinIdle(minIdle);
        druidDataSource.setMaxWait(maxWait);

        druidDataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        druidDataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        druidDataSource.setValidationQuery(validationQuery);
        druidDataSource.setTestWhileIdle(testWhileIdle);
        druidDataSource.setTestOnBorrow(testOnBorrow);
        druidDataSource.setTestOnReturn(testOnReturn);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPerConnectionSize);
        druidDataSource.setPoolPreparedStatements(poolPreparedStatements);

        try {
            druidDataSource.setFilters(filters);
        } catch (SQLException e) {
            logger.error("Druid Configuration DataSource Init Filters",e);
        }
        druidDataSource.setConnectProperties(connectionProperties);
        return druidDataSource;
    }
}
