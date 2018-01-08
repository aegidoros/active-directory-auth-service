
  package com.authenticationservice.ws.controller;

  import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
  import com.authenticationservice.MainApplication;
  import lombok.extern.log4j.Log4j2;
  import org.junit.Before;
  import org.junit.runner.RunWith;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
  import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
  import org.springframework.boot.test.context.SpringBootTest;
  import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
  import org.springframework.test.annotation.DirtiesContext;
  import org.springframework.test.context.ActiveProfiles;
  import org.springframework.test.context.junit4.SpringRunner;
  import org.springframework.web.context.WebApplicationContext;

  import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by jgutierrez on 20/11/2017.
 */
@Log4j2
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {
  MainApplication.class
}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles({
  "local"
})
//@AutoConfigureStubRunner(ids = {"groupId:artifactId-ws:+:stubs"}, workOffline = true)
//@AutoConfigureMockMvc
//@AutoConfigureJsonTesters
@DirtiesContext
public class ContractBase {

  @Autowired
  private WebApplicationContext context;

  @Before
  public void setup() {
    RestAssuredMockMvc.webAppContextSetup(this.context);
  }
}
