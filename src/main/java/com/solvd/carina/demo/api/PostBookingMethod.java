package com.solvd.carina.demo.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/booking", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/bookings/_post/rq.json")
@ResponseTemplatePath(path = "api/bookings/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PostBookingMethod extends AbstractApiMethodV2 {

    public PostBookingMethod() {
        super("api/bookings/_post/rq.json", "api/bookings/_post/rs.json", "api/bookings/user.properties");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
