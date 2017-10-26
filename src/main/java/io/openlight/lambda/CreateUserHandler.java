package io.openlight.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

import io.openlight.domain.User;
import io.openlight.response.Link;
import io.openlight.response.UserResponse;

import java.util.HashMap;
import java.util.Map;


public class CreateUserHandler implements RequestHandler<Object, Object> {

    Gson gson = new Gson();

    public Object handleRequest(final Object input, final Context context) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");

        Link link = new Link();
        link.location = "http://api.openlight.io/users/1234";
        String linkJson = gson.toJson(link);
        

        return new GatewayResponse(linkJson,headers, 201);
    }
}
