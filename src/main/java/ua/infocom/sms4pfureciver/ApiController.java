package ua.infocom.sms4pfureciver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/sendMessage")
    public ResponseEntity<String> getExampleResponse() {
        // Генерируем уникальный идентификатор
        String mid = UUID.randomUUID().toString();

        // Формируем ответ
        String responseBody = String.format("{\"mid\": \"%s\"}", mid);

        // Возвращаем ответ с кодом 202
        return new ResponseEntity<>(responseBody, HttpStatus.ACCEPTED);
    }

    private final AnswerEntityDatabaseService answerEntityDatabaseService;
    private final SmsReportDatabaseService smsReportDatabaseService;

    public ApiController(AnswerEntityDatabaseService answerEntityDatabaseService, SmsReportDatabaseService smsReportDatabaseService) {
        this.answerEntityDatabaseService = answerEntityDatabaseService;
        this.smsReportDatabaseService = smsReportDatabaseService;
    }

    @PostMapping("/requests")
    public ResponseEntity<Void> receiveMessage(@RequestBody ReceiveMessageRequest receiveMessageRequest) {
        System.out.println("Received requests: " + receiveMessageRequest);

        answerEntityDatabaseService.save(receiveMessageRequest);


        // Возвращаем ответ с кодом 204 (No Content)
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/reports") //DLR
    public ResponseEntity<Void> receiveMessage(@RequestBody SmsReportRequest smsReportRequest) { //DLR
        System.out.println("Received report: " + smsReportRequest);

        smsReportDatabaseService.save(smsReportRequest);

        // Возвращаем ответ с кодом 204 (No Content)
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}