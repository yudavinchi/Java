package org.day8.exercise1;

import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.day8.exercise1.httpFacade.HttpFacade;
import org.day8.exercise1.httpFacade.Response;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // get
        String url = "https://reqres.in/api/users?page=2";
        Response response = HttpFacade.get(url);
        System.out.println("Get: " + response.toString());

        // post
        url = "https://reqres.in/api/users";
        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("name", "morpheus"));
        nvps.add(new BasicNameValuePair("job", "secret"));
        response = HttpFacade.post(url, nvps);
        System.out.println("Post: " + response.toString());

        // put
        url = "https://reqres.in/api/users/2";
        nvps.clear();
        nvps.add(new BasicNameValuePair("name", "morpheus"));
        nvps.add(new BasicNameValuePair("job", "zion resident"));
        response = HttpFacade.put(url, nvps);
        System.out.println("Put: " + response.toString());

        // patch
        response = HttpFacade.patch(url, nvps);
        System.out.println("Patch: " + response.toString());

        // delete
        response = HttpFacade.delete(url);
        System.out.println("Delete: " + response.toString());
    }
}
