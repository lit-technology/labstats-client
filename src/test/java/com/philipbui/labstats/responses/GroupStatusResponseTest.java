package com.philipbui.labstats.responses;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GroupStatusResponseTest {

    @Test
    void testJackson() throws IOException {
        GroupStatusResponse groupStatusResponse = new ObjectMapper().readValue(
                GroupStatusResponseTest.class.getClassLoader().getResourceAsStream("group-status-response.json"),
                GroupStatusResponse.class
        );
        assertNotNull(groupStatusResponse);
        assertEquals(0, groupStatusResponse.getOffline());
        assertEquals(1, groupStatusResponse.getOn());
        assertEquals(2, groupStatusResponse.getBusy());
    }
}
