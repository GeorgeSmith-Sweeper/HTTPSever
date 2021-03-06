package com.GeorgesServer.app.com.GeorgesServer.handler;

import com.GeorgesServer.app.StatusCodes;
import com.GeorgesServer.app.com.GeorgesServer.request.ClientRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

class DefaultHandlerTest {
    private DefaultHandler subject;
    private ClientRequest mockClientRequest;

    @BeforeEach
    public void setUp() {
        mockClientRequest = mock(ClientRequest.class);
        subject = new DefaultHandler();
    }

    @Test
    void handlerCallsTheCorrectMethodsWhenBuildingARootResponse() {
        String expectedResponse = StatusCodes.OK + "\n";

        subject.handle();
        String result = subject.format();

        assertEquals(expectedResponse, result);
    }
}

