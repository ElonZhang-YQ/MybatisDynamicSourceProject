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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @Classname SlaveDataSourceConfig
 * @Description TODO
 * @Author Elon.Zhang
 * @Date 2024/6/18
 */
@Configuration
@MapperScan(basePackages = "com.ez.mybatisdynamicsourceproject.mapper.s2", sqlSessionFactoryRef = "SlaveSqlSessionFactory")
public class SlaveDataSourceConfig {

	@Bean(name = "SlaveDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.slave")
	public DataSource getSlaveDataSource() {

		return DataSourceBuilder.create().build();
	}

	@Bean(name = "SlaveSqlSessionFactory")
	public SqlSessionFactory slaveSqlSessionFactory(@Qualifier("SlaveDataSource") DataSource dataSource) throws Exception {

		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		// bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResource("classpath*/mapping/s2/*"));
		return bean.getObject();
	}

	@Bean("SlaveSqlSessionTemplate")
	public SqlSessionTemplate slaveSqlSessionTemplate(@Qualifier("SlaveSqlSessionFactory") SqlSessionFactory sessionFactory) throws Exception {

		return new SqlSessionTemplate(sessionFactory);
	}


}
