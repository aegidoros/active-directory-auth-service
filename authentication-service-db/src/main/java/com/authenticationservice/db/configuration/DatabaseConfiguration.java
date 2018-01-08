
        package com.authenticationservice.db.configuration;

        import com.zaxxer.hikari.HikariDataSource;
        import org.springframework.boot.context.properties.ConfigurationProperties;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.annotation.Primary;
        import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
        import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
        import org.springframework.validation.annotation.Validated;

        import javax.sql.DataSource;

/**
 * <p>
 * Need to configure the following for each DataSource: 
 *
 * - jdbcUrl=jdbc:oracle:thin:@HOST:PORT/BDD driverClassName=oracle.jdbc.OracleDriver
 * - username=xxxxx 
 * - password=xxxxx 
 * - maximumPoolSize=5 
 *
 * Refer to {@link https://github.com/brettwooldridge/HikariCP/wiki/Configuration}. for more information
 * <p>
 * @author cjrequena
 * @since JDK1.8
 */
@Configuration
public class DatabaseConfiguration {

//	@Bean(name = "dataSource", destroyMethod = "")
//	@ConfigurationProperties(prefix = "spring.datasources.mysql_local")
//  @Validated
//	@Primary
//	public DataSource dataSource() {
//		return new HikariDataSource();
//	}

  @Primary
  @Bean(name = "dataSource", destroyMethod = "")
  public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL) // DERBY OR H2 OR HSQL
            .addScript("sql/oracle_compatibility.sql").addScript("sql/create-db.sql").addScript("sql/insert-data.sql").build();
  }

}
