package ua.infocom.sms4pfureciver;

import lombok.Data;

@Data
public class SmsReportRequest {
    private String mid;
    private String date;
    private String status;
}