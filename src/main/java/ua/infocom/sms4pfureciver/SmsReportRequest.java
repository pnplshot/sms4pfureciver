package ua.infocom.sms4pfureciver;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class SmsReportRequest {
    private String mid;
    private Timestamp date;
    private String status;
}