package ua.infocom.sms4pfureciver;

import lombok.Data;

import java.util.Map;

@Data
public class ReceiveMessageRequest {
    private String rid;
    private String date;
    private String source;
    private String destination;
    private String params;
    private String bearerType;
    private String contentType;
    private String content;
}