package com.evolenta.task.service;
import com.evolenta.task.dto.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    List<Message> getAllMessages();
    Optional<Message> getMessage(int id);
    Message addMessage(Message Message);
    Message updateMessage(int id ,Message Message);
    Boolean deleteMessage(int id);
}
