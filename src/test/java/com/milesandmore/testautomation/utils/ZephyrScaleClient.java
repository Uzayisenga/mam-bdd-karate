package com.milesandmore.testautomation.utils;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Base64;
import java.nio.charset.StandardCharsets;

import org.json.*; // Optional: Use org.json or Jackson

public class ZephyrScaleClient {

    private final String baseUrl;
    private final String authHeader;

    public ZephyrScaleClient(String baseUrl, String accessToken) {
        this.baseUrl = baseUrl;
        this.authHeader = "Bearer " + accessToken;
    }

    /**
     * Queries test cases from Zephyr Scale using a TQL filter.
     */
    public List<TestCase> queryTestCases(String tql) {
        List<TestCase> results = new ArrayList<>();

        try {
            String encodedTql = URLEncoder.encode(tql, StandardCharsets.UTF_8.toString());
            String url = baseUrl + "/testcases?query=" + encodedTql;

            String response = sendGetRequest(url);

            // Parse JSON response
            JSONObject json = new JSONObject(response);
            JSONArray items = json.getJSONArray("values");

            for (int i = 0; i < items.length(); i++) {
                JSONObject item = items.getJSONObject(i);
                String key = item.getString("key");
                String name = item.getString("name");

                results.add(new TestCase(key, name));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return results;
    }

    /**
     * Downloads the feature file (Gherkin) content for a single test case.
     */
    public String downloadFeatureFile(String testCaseKey) {
        try {
            String url = baseUrl + "/testcases/" + testCaseKey + "/feature";
            return sendGetRequest(url);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * Generic GET request handler with authentication.
     */
    private String sendGetRequest(String urlString) throws IOException {
        URL url = new URL(urlString);

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Authorization", authHeader);
        con.setRequestProperty("Accept", "application/json");

        int status = con.getResponseCode();

        InputStream stream = (status > 299) ? con.getErrorStream() : con.getInputStream();
        BufferedReader in = new BufferedReader(new InputStreamReader(stream));

        StringBuilder content = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        con.disconnect();

        return content.toString();
    }
}

