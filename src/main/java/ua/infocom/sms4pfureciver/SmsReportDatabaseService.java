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


    public void saveReport(SmsReportRequest smsReportRequest) {
        Optional<Sms> smsOptional = smsRepository.findByMsgId(smsReportRequest.getMid());

        smsOptional.ifPresent(sms -> {
            sms.setRecived(new Timestamp(Long.parseLong(smsReportRequest.getDate())));
            sms.setStatus(smsReportRequest.getStatus());
            smsRepository.save(sms);
        });
    }
}
