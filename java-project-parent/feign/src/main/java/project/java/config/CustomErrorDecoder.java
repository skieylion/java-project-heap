package project.java.config;

import feign.FeignException;
import feign.Response;
import feign.RetryableException;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {

        System.out.println("CustomErrorDecoder");
        switch (response.status()) {
            case 404:
                return new FeignException.NotFound("ErrorNotFound", response.request(), response.request().body(), response.headers());
            default:
                return new Exception("Any");
        }
    }
}
