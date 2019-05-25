package com.philipbui.labstats;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.philipbui.labstats.responses.GroupStatusResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Collections;

@SuppressWarnings({"WeakerAccess", "unused"})
public class LabStatsClient {

    private static final Logger logger = LogManager.getLogger(LabStatsClient.class);
    private final String labStatsApiKey;
    private final Region region;
    private final String baseURL;
    private final CloseableHttpClient client;
    private final ObjectMapper reader;

    public LabStatsClient(String labStatsApiKey, Region region) {
        this(labStatsApiKey, region, HttpClientBuilder.create()
                .setDefaultHeaders(Collections.singletonList(
                        new BasicHeader("Authorization", labStatsApiKey))).build());
    }

    public LabStatsClient(String labStatsApiKey, Region region, CloseableHttpClient client) {
        this.labStatsApiKey = labStatsApiKey;
        this.region = region;
        this.baseURL = region.getBaseURL();
        if (labStatsApiKey == null || labStatsApiKey.length() == 0) {
            throw new IllegalArgumentException("No LabStats LABSTATS_API_KEY specified");
        }
        this.client = client;
        reader = new ObjectMapper();
    }

    GroupStatusResponse getLabStatsGroupStatus(int groupId) throws IOException {
        String uri = baseURL + String.format("/groups/%d/status", groupId);
        try (CloseableHttpResponse response = getClient().execute(new HttpGet(uri))) {
            logger.info("GET /" + uri);
            return getReader().readValue(response.getEntity().getContent(), GroupStatusResponse.class);
        } catch (Exception e) {
            throw new IOException("Error getting LabStats GET /" + uri, e);
        }
    }

    public String getLabStatsApiKey() {
        return labStatsApiKey;
    }

    public Region getRegion() {
        return region;
    }

    private CloseableHttpClient getClient() {
        return client;
    }

    private ObjectMapper getReader() {
        return reader;
    }
}
