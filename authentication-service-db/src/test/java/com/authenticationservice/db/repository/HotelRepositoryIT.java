package com.authenticationservice.db.repository;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.DbSetupTracker;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import com.authenticationservice.db.configuration.TestDatabaseConfiguration;
import com.authenticationservice.db.configuration.TestMyBatisConfiguration;
import com.authenticationservice.db.entity.HotelEntity;
import com.authenticationservice.db.repository.HotelRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import javax.sql.DataSource;

/**
 * Created by jgutierrez on 04/05/2017.
 */
@RunWith(SpringRunner.class)
@ActiveProfiles({"local", "integration-test"})
@SpringBootTest(classes = {TestDatabaseConfiguration.class, TestMyBatisConfiguration.class})
public class HotelRepositoryIT {

  private static DbSetupTracker TRACKER = new DbSetupTracker();

  @Autowired
  private DataSource dataSource;

  @Autowired
  private HotelRepository hotelRepository;


  @Test
  public void testMapper() {

    HotelEntity entityResponse = hotelRepository.findById(2);
    assertEquals(entityResponse.getName(), "Hotel costa mediterranea");

    HotelEntity entity = new HotelEntity();
    entity.setHotelId(123);
    entity.setRate("rate");
    entity.setName("name");
    entity.setDescription("description");
    entity.setEmail("email");
    entity.setFax("fax");
    entity.setLocalCurrencyCode("EUR");
    entity.setPhone("Phone");

    hotelRepository.insert(entity);
    entityResponse = hotelRepository.findById(123);

    assertEquals(entityResponse.getName(), entity.getName());
  }

  @Before
  public void prepare() throws Exception {

    Operation operation = Operations.sequenceOf(
            Operations.deleteAllFrom("hotel"),
            Operations.insertInto("hotel").columns("HOTEL_ID", "NAME", "EMAIL", "PHONE", "FAX", "RATE", "LOCAL_CURRENCY_CODE", "DESCRIPTION")
                    .values(2, "Hotel costa mediterranea", "info@hotelcostamediterranea.com", "555 555 555", "555 555 555", "5-start", "EUR", "TEST")
                    .build());

    DbSetup dbSetup = new DbSetup(new DataSourceDestination(dataSource), operation);
    TRACKER.launchIfNecessary(dbSetup);

  }
}
