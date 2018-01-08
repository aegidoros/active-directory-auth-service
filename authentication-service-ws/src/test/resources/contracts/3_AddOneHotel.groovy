/**
 * Created by jgutierrez on 20/11/2017.
 */
org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        url '/authentication-service/hotels/'
        body("""{
  "description": "string",
  "email": "string",
  "fax": "string",
  "hotel_id": 6,
  "local_currency_code": "string",
  "name": "string",
  "phone": "string",
  "rate": "string"
}""")
        headers {
            header('''Accept''', '''*/*''')
            header('''Content-Type''', '''application/json''')
        }
    }
    response {
        status 201
    }
}
