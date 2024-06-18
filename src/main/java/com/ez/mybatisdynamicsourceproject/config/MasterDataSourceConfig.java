package com.ez.mybatisdynamicsourceproject.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @Classname MasterDataSourceConfig
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/18
 */
@Configuration
@MapperScan(basePackages = "com.ez.mybatisdynamicsourceproject.mapper.s1", sqlSessionFactoryRef = "MasterSqlSessionFactory")
public class MasterDataSourceConfig {

	@Bean(name = "MasterDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.master")
	public DataSource getMasterDataSource() {

		return DataSourceBuilder.create().build();
	}

	@Bean(name = "MasterSqlSessionFactory")
	@Primary
	public SqlSessionFactory masterSqlSessionFactory(@Qualifier("MasterDataSource") DataSource dataSource) throws Exception {

		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		// bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResource("classpath*/mapping/s1/*"));
		return bean.getObject();
	}

	@Bean("MasterSqlSessionTemplate")
	@Primary
	public SqlSessionTemplate masterSqlSessionTemplate(@Qualifier("MasterSqlSessionFactory") SqlSessionFactory sessionFactory) throws Exception {

		return new SqlSessionTemplate(sessionFactory);
	}

}
