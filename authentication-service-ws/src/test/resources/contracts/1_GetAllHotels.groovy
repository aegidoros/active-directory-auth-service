/**
 * Created by jgutierrez on 20/11/2017.
 */
org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/authentication-service/hotels/'
    }
    response {
        status 200
        body("""[
  {
    "hotel_id": 1,
    "name": "Hotel costa azul",
    "email": "info@hotelcostaazul.com",
    "phone": "555 555 555",
    "fax": "555 555 555",
    "rate": "5-start",
    "local_currency_code": "EUR",
    "description": "Default Description"
  },
  {
    "hotel_id": 2,
    "name": "Hotel costa dorada",
    "email": "info@hotelcostadorada.com",
    "phone": "555 555 555",
    "fax": "555 555 555",
    "rate": "5-start",
    "local_currency_code": "EUR",
    "description": "Default Description"
  },
  {
    "hotel_id": 3,
    "name": "Hotel costa brava",
    "email": "info@hotelcostabrava.com",
    "phone": "555 555 555",
    "fax": "555 555 555",
    "rate": "5-start",
    "local_currency_code": "EUR",
    "description": "Default Description"
  },
  {
    "hotel_id": 4,
    "name": "Hotel costa mediterranea",
    "email": "info@hotelcostamediterranea.com",
    "phone": "555 555 555",
    "fax": "555 555 555",
    "rate": "5-start",
    "local_currency_code": "EUR",
    "description": "Default Description"
  }
]""")
        headers {
            contentType('application/json')
        }
    }
}
