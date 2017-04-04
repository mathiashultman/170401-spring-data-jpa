package biz.mathias.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories(basePackages="biz.mathias.db")
public class JpaConfiguration {
	@Bean
	public DataSource mysqlDataSource(){
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/b");
		dataSource.setUsername("root");
		dataSource.setPassword("");
		return dataSource;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
	  HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	  adapter.setDatabase(Database.MYSQL);
	  adapter.setShowSql(true);
	  adapter.setGenerateDdl(true);
	  return adapter;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(
	        DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
	  LocalContainerEntityManagerFactoryBean emfb =
	      new LocalContainerEntityManagerFactoryBean();
	  emfb.setDataSource(mysqlDataSource());
	  emfb.setJpaVendorAdapter(jpaVendorAdapter());
	  emfb.setPackagesToScan("biz.mathias.db","biz.mathias.domain");
	  return emfb;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}
}