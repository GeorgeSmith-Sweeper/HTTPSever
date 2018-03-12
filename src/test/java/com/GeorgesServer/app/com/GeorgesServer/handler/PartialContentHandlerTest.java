package com.GeorgesServer.app.com.GeorgesServer.handler;

import com.GeorgesServer.app.com.GeorgesServer.request.ClientRequest;
import com.GeorgesServer.app.com.GeorgesServer.response.ServerResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PartialContentHandlerTest {
    private PartialContentHandler subject;
    private ClientRequest mockClientRequest;

    @BeforeEach
    public void setUp() {
        String publicFolderPath = "../cob_spec/public/";
        mockClientRequest = mock(ClientRequest.class);
        subject = new PartialContentHandler(publicFolderPath);
    }

    @Test
    void handlerBuildsA206Status() {
        String expectedCode = "206";
        String expectedMsg = "Partial Content";
        String expectedVersion = "HTTP/1.1";
        String expectedBody = "This ";

        ArrayList<String> headers = new ArrayList<>();
        headers.add("Range: bytes=0-4");
        when(mockClientRequest.getHeaders()).thenReturn(headers);

        ServerResponse result = subject.handle(mockClientRequest);

        assertEquals(expectedCode, result.getStatusCode());
        assertEquals(expectedMsg, result.getStatusMsg());
        assertEquals(expectedVersion, result.getHttpVersion());
        assertEquals(expectedBody, result.getBody());
    }
}