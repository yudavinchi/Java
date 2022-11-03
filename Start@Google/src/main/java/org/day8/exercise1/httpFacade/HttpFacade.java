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

    public static Map<String, Object> get(String url) {

        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(url);

            try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
                System.out.println(response.getCode() + " " + response.getReasonPhrase());
                HttpEntity entity = response.getEntity();
                String json = EntityUtils.toString(entity);

                Gson gson = new Gson();
                Map<String, Object> map = gson.fromJson(json, Map.class); // deserializes json into map

                EntityUtils.consume(entity);

                return map;
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, Object> post(String url, List<NameValuePair> nvps) {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, StandardCharsets.UTF_8));

            try (CloseableHttpResponse response = httpclient.execute(httpPost)) {
                System.out.println(response.getCode() + " " + response.getReasonPhrase());
                HttpEntity entity = response.getEntity();
                String json = EntityUtils.toString(entity);

                Gson gson = new Gson();
                Map<String, Object> map = gson.fromJson(json, Map.class); // deserializes json into map

                EntityUtils.consume(entity);

                return map;
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, Object> put(String url, List<NameValuePair> nvps) {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            HttpPut httpPut = new HttpPut(url);
            httpPut.setEntity(new UrlEncodedFormEntity(nvps));
            httpPut.setEntity(new UrlEncodedFormEntity(nvps, StandardCharsets.UTF_8));

            try (CloseableHttpResponse response = httpclient.execute(httpPut)) {
                System.out.println(response.getCode() + " " + response.getReasonPhrase());
                HttpEntity entity = response.getEntity();
                String json = EntityUtils.toString(entity);

                Gson gson = new Gson();
                Map<String, Object> map = gson.fromJson(json, Map.class); // deserializes json into map

                EntityUtils.consume(entity);

                return map;
            } catch (ParseException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, Object> patch(String url, List<NameValuePair> nvps) {
        try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

            HttpPatch httpPatch = new HttpPatch(url);
            httpPatch.setEntity(new UrlEncodedFormEntity(nvps));
            httpPatch.setEntity(new UrlEncodedFormEntity(nvps, StandardCharsets.UTF_8));

            try (CloseableHttpResponse response = httpclient.execute(httpPatch)) {
                System.out.println(response.getCode() + " " + response.getReasonPhrase());
                HttpEntity entity = response.getEntity();
                String json = EntityUtils.toString(entity);

                Gson gson = new Gson();
                Map<String, Object> map = gson.fromJson(json, Map.class); // deserializes json into map

                EntityUtils.consume(entity);

                return map;
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, Object> delete(String url) {
        return null;
    }


    public static void main(String[] args) throws IOException {
        HttpFacade httpFacade = new HttpFacade();

        String url = "https://reqres.in/api/users?page=2";

        Map<String, Object> map = httpFacade.get(url);

        url = "https://reqres.in/api/users";

        List<NameValuePair> nvps = new ArrayList<>();
        nvps.add(new BasicNameValuePair("name", "morpheus"));
        nvps.add(new BasicNameValuePair("job", "secret"));

        map = httpFacade.post(url, nvps);

        url = "https://reqres.in/api/users/2";

        nvps.clear();
        nvps.add(new BasicNameValuePair("name", "morpheus"));
        nvps.add(new BasicNameValuePair("job", "zion resident"));

        map = httpFacade.put(url, nvps);

        map = httpFacade.patch(url, nvps);

        map = httpFacade.delete(url);
    }
}
