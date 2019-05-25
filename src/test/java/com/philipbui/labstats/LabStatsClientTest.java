package com.philipbui.labstats;

import com.philipbui.labstats.responses.GroupStatusResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LabStatsClientTest {

    private String apiKey;

    @BeforeAll
    void setUp() {
        this.apiKey = System.getenv("LABSTATS_API_KEY");
    }

    private boolean hasApiKey() {
        return apiKey != null && apiKey.isEmpty();
    }

    @Test
    void testGroupStatusResponse() throws IOException {
        if (!hasApiKey()) {
            return;
        }
        LabStatsClient labStatsClient = new LabStatsClient(apiKey, Region.SEA);
        GroupStatusResponse response = labStatsClient.getLabStatsGroupStatus(1);
        assertNotNull(response);
    }
}
