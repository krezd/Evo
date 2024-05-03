package com.evolenta.task.controller;

import com.evolenta.task.dto.Message;
import com.evolenta.task.dto.Person;
import com.evolenta.task.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private  MessageService messageService;

    @GetMapping
    public ResponseEntity<?> getAllMessage() {
        return ResponseEntity.ok(messageService.getAllMessages());
    }

    @GetMapping("/{id}")
    public Optional<?> findMessageById(@PathVariable int id) {
        return messageService.getMessage(id);
    }

    @PostMapping("")
    public ResponseEntity<?> addMessage(@RequestBody Message message) {
        return new ResponseEntity<>(messageService.addMessage(message), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMessage(@PathVariable int id, @RequestBody Message message) {
        return new ResponseEntity<>(messageService.updateMessage(id,message),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMessage(@PathVariable int id) {
        messageService.deleteMessage(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
