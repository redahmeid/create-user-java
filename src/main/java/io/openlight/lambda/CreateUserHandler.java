package io.openlight.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.HashMap;
import java.util.Map;

import com.aws.codestar.projecttemplates.GatewayResponse;

/**
 * Handler for requests to Lambda function.
 */
public class CreateUserHandler implements RequestHandler<Object, Object> {

    public Object handleRequest(final Object input, final Context context) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return new GatewayResponse("{ \"Output\": \"Hello World!\"}", headers, 200);
    }
}
