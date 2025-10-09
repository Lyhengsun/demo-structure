package com.test.demostructure.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.demostructure.exception.BadRequestException;
import com.test.demostructure.exception.ExceptionDetail;
import com.test.demostructure.exception.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.apache.hc.core5.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;

public class RetreiveMessageErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        ExceptionDetail detail;
        try (InputStream bodyIs = response.body().asInputStream()) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            // Use the injected objectMapper
            detail = objectMapper.readValue(bodyIs, ExceptionDetail.class);
        } catch (IOException e) {
            // Log the error or wrap it in a more specific exception
            return new RuntimeException("Failed to parse error response body", e);
        }

        return switch (response.status()) {
            case HttpStatus.SC_BAD_REQUEST -> new BadRequestException(
                    detail != null && detail.getDetail() != null ? detail.getDetail() : "Bad Request");
            case HttpStatus.SC_NOT_FOUND -> new NotFoundException(
                    detail != null && detail.getDetail() != null ? detail.getDetail() : "Not Found");
            default -> errorDecoder.decode(methodKey, response);
        };
    }

}
