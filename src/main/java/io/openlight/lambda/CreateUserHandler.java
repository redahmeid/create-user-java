package io.openlight.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.google.gson.Gson;

import io.openlight.domain.User;
import io.openlight.neo4j.Inserter;
import io.openlight.response.Link;

import java.util.HashMap;
import java.util.Map;


public class CreateUserHandler implements RequestHandler<Object, Object> {

    Gson gson = new Gson();

    public GatewayResponse handleRequest(final Object input, final Context context) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        System.out.println(gson.toJson(input));
        String id = Inserter.insert("Hello","Hi");
        Link link = new Link();
        link.location = "http://api.openlight.io/users/"+id;
        String linkJson = gson.toJson(link);
        

        return new GatewayResponse(linkJson,headers, 201);
    }
}
