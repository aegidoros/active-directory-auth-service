package com.authenticationservice.db.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * <p>
 * <p>
 * <p>
 * <p>
 * @author jgutierrez
 * @version 1.0
 * @since JDK1.8
 * @see
 *
 */
@Configuration
public class TestDatabaseConfiguration {

  @Primary
  @Bean(name = "dataSource", destroyMethod = "")
  public DataSource dataSource() {
    try {
      return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL) // DERBY OR H2 OR HSQL
              .addScript("sql/oracle_compatibility.sql").addScript("sql/create-db.sql").addScript("sql/insert-data.sql").build();
    } catch (Exception ex) {
      return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.HSQL).build();
    }
  }

}
