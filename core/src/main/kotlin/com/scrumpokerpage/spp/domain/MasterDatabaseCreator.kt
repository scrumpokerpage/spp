package com.scrumpokerpage.spp.domain

import org.springframework.context.annotation.Bean
import org.springframework.core.env.Environment
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import java.util.*
import javax.sql.DataSource
import org.springframework.boot.Banner

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration
import org.springframework.boot.jdbc.DataSourceBuilder

import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties

@SpringBootApplication(exclude=[JpaRepositoriesAutoConfiguration::class, LiquibaseAutoConfiguration::class])
@EntityScan(basePackages = ["com.scrumpokerpage.spp.domain"])
class MasterDatabaseCreator {

	@Bean
	fun dataSource(env: Environment): DataSource {
		return DataSourceBuilder.create()
			.driverClassName(env.getProperty("spring.datasource.driver-class-name", "org.h2.Driver"))
			//.url(env.getRequiredProperty("spring.datasource.url"))
			.url("jdbc:h2:file:./masterdb;AUTO_SERVER=TRUE;DB_CLOSE_DELAY=-1;INIT=CREATE SCHEMA IF NOT EXISTS SPP\\;SET SCHEMA SPP")
			.username(env.getProperty("spring.datasource.username", "sa"))
			.password(env.getProperty("spring.datasource.password", ""))
			.build()
	}

	@Bean
	fun entityManagerFactory(dataSource: DataSource?, jpaProperties: JpaProperties?): LocalContainerEntityManagerFactoryBean {

		val emf = LocalContainerEntityManagerFactoryBean()
		emf.setDataSource( dataSource!! )
		emf.setJpaVendorAdapter(HibernateJpaVendorAdapter())
		emf.setPackagesToScan("com.scrumpokerpage.spp.domain")

		val jpaProps = jpaProperties?.properties?.toProperties() ?: Properties()
		jpaProps.put("hibernate.hbm2ddl.auto", "create")
		jpaProps.put("hibernate.show_sql", "true")
		jpaProps.put("hibernate.implicit_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringImplicitNamingStrategy")
		jpaProps.put("hibernate.physical_naming_strategy", "org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy")

		emf.setJpaProperties(jpaProps)
		return emf
	}

	companion object {

		@JvmStatic
		fun main(args: Array<String>) {
			val application = SpringApplication(MasterDatabaseCreator::class.java)
			application.setBannerMode(Banner.Mode.OFF)
			application.run(*args)
		}
	}
}

