package com.ds.dfsm.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@MapperScan("com.ds.dfsm.dao")
@EnableTransactionManagement
public class DataSourceConfig {
    private static Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Value("${mybatis.mapper-locations}")
    protected String mapperLoction;

    @Value("${mybatis.type-aliases-package}")
    protected String packageAliasLocation;

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        sqlSessionFactoryBean.setTypeAliasesPackage(packageAliasLocation);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLoction));
        return sqlSessionFactoryBean.getObject();
    }

}
