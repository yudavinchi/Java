package org.day8.exercise1.httpFacade;

import com.google.gson.Gson;

import org.apache.hc.client5.http.classic.methods.*;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.*;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import java.io.IOException;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HttpFacade {

    public static Response get(String url) {

        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(url);

            try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
                HttpEntity entity = response.getEntity();
                String json = EntityUtils.toString(entity);

                Gson gson = new Gson();
                Map<String, Object> map = gson.fromJson(json, Map.class); // deserializes json into map

                EntityUtils.consume(entity);

                return new Response(response.getCode(), map);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Response post(String url, List<NameValuePair> nvps) {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, StandardCharsets.UTF_8));

            try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
                HttpEntity entity = response.getEntity();
                String json = EntityUtils.toString(entity);

                Gson gson = new Gson();
                Map<String, Object> map = gson.fromJson(json, Map.class); // deserializes json into map

                EntityUtils.consume(entity);

                return new Response(response.getCode(), map);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Response put(String url, List<NameValuePair> nvps) {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            HttpPut httpPut = new HttpPut(url);
            httpPut.setEntity(new UrlEncodedFormEntity(nvps));
            httpPut.setEntity(new UrlEncodedFormEntity(nvps, StandardCharsets.UTF_8));

            try (CloseableHttpResponse response = httpclient.execute(httpPut)) {
                HttpEntity entity = response.getEntity();
                String json = EntityUtils.toString(entity);

                Gson gson = new Gson();
                Map<String, Object> map = gson.fromJson(json, Map.class); // deserializes json into map

                EntityUtils.consume(entity);

                return new Response(response.getCode(), map);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Response patch(String url, List<NameValuePair> nvps) {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            HttpPatch httpPatch = new HttpPatch(url);
            httpPatch.setEntity(new UrlEncodedFormEntity(nvps));
            httpPatch.setEntity(new UrlEncodedFormEntity(nvps, StandardCharsets.UTF_8));

            try (CloseableHttpResponse response = httpclient.execute(httpPatch)) {
                HttpEntity entity = response.getEntity();
                String json = EntityUtils.toString(entity);

                Gson gson = new Gson();
                Map<String, Object> map = gson.fromJson(json, Map.class); // deserializes json into map

                EntityUtils.consume(entity);

                return new Response(response.getCode(), map);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Response delete(String url) {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpDelete httpDelete = new HttpDelete(url);

            try (CloseableHttpResponse response = httpclient.execute(httpDelete)) {
                return new Response(response.getCode(), null);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {

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
