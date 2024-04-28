package com.evolenta.task.controller;

import com.evolenta.task.dto.Message;
import com.evolenta.task.dto.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/message")
public class MessageController {
    private List<Message> messages = new ArrayList<>(Arrays.asList(
            new Message(1, "Title1", "text1", LocalDateTime.of(2024,4,28,12,14)),
            new Message(2, "Title2", "text2", LocalDateTime.of(2024,3,26,15,54)),
            new Message(3, "Title3", "text3", LocalDateTime.of(2024,1,27,17,34)),
            new Message(4, "Title4", "text4", LocalDateTime.of(2024,2,29,18,44))
    ));

    @GetMapping
    public ResponseEntity<?> getAllMessage() {
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/{id}")
    public Optional<?> findMessageById(@PathVariable int id) {
        return messages.stream().filter(p -> p.getId() == id).findFirst();
    }

    @PostMapping("")
    public ResponseEntity<?> addMessage(@RequestBody Message message) {
        messages.add(message);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMessage(@PathVariable int id, @RequestBody Message message) {
        int index = -1;
        for (Message p : messages) {
            if (p.getId() == id) {
                index = messages.indexOf(p);
                messages.set(index, message);
            }
        }
        if (index == -1) {
            addMessage(message);
        }
        return new ResponseEntity<>(message,HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable int id) {
        messages.removeIf(p -> p.getId() == id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
