package org.day8.exercise1.httpFacade;

import java.util.Map;

public class Response {
    int status;
    Map<String, Object> body;

    public Response(int status, Map<String, Object> body){
        this.status = status;
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public Map<String, Object> getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status=" + status +
                ", body=" + body +
                '}';
    }
}
