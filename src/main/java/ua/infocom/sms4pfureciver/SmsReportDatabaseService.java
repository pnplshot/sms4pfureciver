package ua.infocom.sms4pfureciver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class SmsReportDatabaseService {

    private final SmsRepository smsRepository;

    @Autowired
    public SmsReportDatabaseService(SmsRepository smsRepository) {
        this.smsRepository = smsRepository;
    }

    public void save(SmsReportRequest smsReportRequest) {
        Sms sms = convertToSMS(smsReportRequest);
        smsRepository.save(sms);
    }


    public void saveReport(SmsReportRequest smsReportRequest) {
        Optional<Sms> smsOptional = smsRepository.findByMsgId(smsReportRequest.getMid());

        smsOptional.ifPresent(sms -> {
            sms.setRecived(smsReportRequest.getDate());
            sms.setStatus(smsReportRequest.getStatus());
            smsRepository.save(sms);
        });
    }

    private Sms convertToSMS(SmsReportRequest smsReportRequest) {
        Sms sms = new Sms();

        sms.setMsgId(smsReportRequest.getMid());
        sms.setRecived(smsReportRequest.getDate());
        sms.setStatus(smsReportRequest.getStatus());

        return sms;
    }
}
