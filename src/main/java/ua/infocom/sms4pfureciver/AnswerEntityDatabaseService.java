package ua.infocom.sms4pfureciver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AnswerEntityDatabaseService {

    private final AnswerEntityRepository answerEntityRepository;

    @Autowired
    public AnswerEntityDatabaseService(AnswerEntityRepository answerEntityRepository) {
        this.answerEntityRepository = answerEntityRepository;
    }

    public void save(ReceiveMessageRequest receiveMessageRequest) {
        AnswerEntity entity = convertToEntity(receiveMessageRequest);
        answerEntityRepository.save(entity);
    }

    private AnswerEntity convertToEntity(ReceiveMessageRequest receiveMessageRequest) {
        AnswerEntity entity = new AnswerEntity();
        entity.setRid(receiveMessageRequest.getRid());
        entity.setDate(receiveMessageRequest.getDate());
        entity.setSource(receiveMessageRequest.getSource());
        entity.setDestination(receiveMessageRequest.getDestination());
        //entity.setParams(receiveMessageRequest.getParams());
        entity.setBearerType(receiveMessageRequest.getBearerType());
        entity.setContentType(receiveMessageRequest.getContentType());
        entity.setContent(receiveMessageRequest.getContent());
        return entity;
    }

    private String mapToString(Map<String, String> map) {
        // Преобразование Map в строку,
        return map != null ? map.toString() : null;
    }
}