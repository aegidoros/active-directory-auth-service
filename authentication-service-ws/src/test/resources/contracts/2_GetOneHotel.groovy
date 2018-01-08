/**
 * Created by jgutierrez on 20/11/2017.
 */
org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/authentication-service/hotels/1'
    }
    response {
        status 200
        body("""
  {
    "hotel_id": 1,
    "name": "Hotel costa azul",
    "email": "info@hotelcostaazul.com",
    "phone": "555 555 555",
    "fax": "555 555 555",
    "rate": "5-start",
    "local_currency_code": "EUR",
    "description": "Default Description"
  }""")
        headers {
            contentType('application/json')
        }
    }
}
