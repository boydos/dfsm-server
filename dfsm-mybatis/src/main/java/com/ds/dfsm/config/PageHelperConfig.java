package com.ds.dfsm.config;

import com.github.pagehelper.PageInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class PageHelperConfig {

    @Value("${pagehelper.help-dialect:mysql}")
    private String helperDialect;

    @Value("${pagehelper.params:pageNum=pageNum;pageSize=pageSize;count=countSql;reasonable=reasonable;pageSizeZero=pageSizeZero}")
    private String params;

    @Value("${pagehelper.reasonable:false}")
    private String reasonable;

    @Value("${pagehelper.support-methods-arguments:false}")
    private String supportMethodsArguments;

    @Value("${pagehelper.return-page-info:}")
    private String returnPageInfo;

    @Bean
    public PageInterceptor pageInterceptor() {
        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", helperDialect);
        properties.setProperty("params", params);
        properties.setProperty("reasonable", reasonable);
        properties.setProperty("supportMethodsArguments", supportMethodsArguments);
        properties.setProperty("returnPageInfo", returnPageInfo);
        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}
