package ua.infocom.sms4pfureciver;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerEntityRepository extends JpaRepository<AnswerEntity, Long> {
    // Дополнительные методы могут быть добавлены при необходимости
}