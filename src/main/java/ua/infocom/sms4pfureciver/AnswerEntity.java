package ua.infocom.sms4pfureciver;

import lombok.Data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Data
public class AnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String rid;
    private String date;
    private String source;
    private String destination;
    private String params; // представление Map в виде строки
    private String bearerType;
    private String contentType;
    private String content;
}