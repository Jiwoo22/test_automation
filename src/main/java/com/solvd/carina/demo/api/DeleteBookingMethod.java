package com.solvd.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

import java.util.Base64;

@Endpoint(url="${base_url}/booking/${id}", methodType = HttpMethodType.DELETE)
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class DeleteBookingMethod extends AbstractApiMethodV2 {

    public DeleteBookingMethod(String bookingId) {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("id", bookingId);

        String authString = "admin:password123";
        String encodedAuthString = Base64.getEncoder().encodeToString(authString.getBytes());
        String authHeader = "Basic " + encodedAuthString;
        setHeader("Authorization", authHeader);
    }
}
