package com.solvd.carina.demo;


import com.solvd.carina.demo.api.DeleteBookingMethod;
import com.solvd.carina.demo.api.GetBookingMethod;
import com.solvd.carina.demo.api.PostBookingMethod;
import com.solvd.carina.demo.api.UpdateBookingMethod;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.Properties;

/**
 * @author Jiwoo
 */
public class BookingAPITest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private int bookingId;


    @Test(priority = 1)
    @MethodOwner(owner= "Jiwoo")
    public void testCreateBooking() throws Exception {
        LOGGER.info("test POST api");

        // prepare a request
        PostBookingMethod api = new PostBookingMethod();
        api.setProperties("api/bookings/user.properties");

        api.expectResponseStatus(HttpResponseStatusType.OK_200);

        // make a call to endpoint
        Response response = api.callAPIExpectSuccess();

        // validate the response
        api.validateResponse();

        // retrieve bookingId
        String responseBody = response.asString();
        JSONObject jsonObject = new JSONObject(responseBody);
        bookingId = jsonObject.getInt("bookingid");
    }


    @Test(priority = 2)
    @MethodOwner(owner = "Jiwoo")
    public void testGetBooking() throws Exception {
        LOGGER.info("test GET api");

        if(bookingId == 0){

            // load properties from file
            Properties properties = new Properties();
            try {
                properties.load(new FileReader("/Users/jiwoochoi/Desktop/projects/Solvd_practice/carina/"
                        + "carina-demo/src/test/resources/api/bookings/user.properties"));
            } catch (IOException e) {
                LOGGER.error("Failed to load properties from file", e);
                throw e;
            }

            // Get the bookingId
            bookingId = Integer.valueOf(properties.getProperty("id"));

            if (bookingId == 0) {
                throw new Exception("ID property not found");
            }
        }

        System.out.println("bookingId" + bookingId);

        // prepare a request
        GetBookingMethod api = new GetBookingMethod(String.valueOf(bookingId));
        api.setProperties("api/bookings/user.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
        api.validateResponseAgainstSchema("api/bookings/_get/rs.schema");
    }


    @Test(priority = 3)
    @MethodOwner(owner = "Jiwoo")
    public void testUpdateBooking() throws Exception {
        LOGGER.info("test UPDATE api");

        // prepare a request
        UpdateBookingMethod api = new UpdateBookingMethod(String.valueOf(bookingId));
        api.setProperties("api/bookings/user.properties");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }


    @Test(priority = 4)
    @MethodOwner(owner = "Jiwoo")
    public void testDeleteBooking() throws Exception {
        LOGGER.info("test DELETE api");

        // prepare a request
        DeleteBookingMethod api = new DeleteBookingMethod(String.valueOf(bookingId));
        api.setProperties("api/bookings/user.properties");
        api.callAPI();
        api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
    }
}
