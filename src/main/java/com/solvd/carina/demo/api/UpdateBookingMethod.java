package com.solvd.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.*;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

import java.util.Base64;

@Endpoint(url = "${base_url}/booking/${id}", methodType = HttpMethodType.PUT)
@RequestTemplatePath(path = "api/bookings/_put/rq.json")
@ResponseTemplatePath(path = "api/bookings/_put/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class UpdateBookingMethod extends AbstractApiMethodV2 {

    public UpdateBookingMethod(String bookingId) {
        super("api/bookings/_put/rq.json", "api/bookings/_put/rs.json", "api/bookings/user.properties");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("id", bookingId);

        String authString = "admin:password123";
        String encodedAuthString = Base64.getEncoder().encodeToString(authString.getBytes());
        String authHeader = "Basic " + encodedAuthString;
        setHeader("Authorization", authHeader);
    }
}
