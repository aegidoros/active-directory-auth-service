/**
 * Created by jgutierrez on 20/11/2017.
 */
org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'DELETE'
        url '/authentication-service/hotels/6'
    }
    response {
        status 204
    }
}
