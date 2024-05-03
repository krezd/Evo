package com.evolenta.task.service.serviceImpl;

import com.evolenta.task.dto.Message;
import com.evolenta.task.repository.MessageRepository;
import com.evolenta.task.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Optional<Message> getMessage(int id) {
        return messageRepository.findById(id);
    }

    @Override
    public Message addMessage(Message message) {
        messageRepository.save(message);
        return message;
    }

    @Override
    public Message updateMessage(int id, Message message) {
        Optional<Message> messageOptional = messageRepository.findById(id);
        if (messageOptional.isPresent()) {
            Message newMessage = new Message(
                    id,
                    message.getTitle(),
                    message.getText(),
                    message.getTime()
            );
            messageRepository.save(newMessage);
            return newMessage;
        }
        return addMessage(message);
    }

    @Override
    public Boolean deleteMessage(int id) {
        if (messageRepository.existsById(id)) {
            messageRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
