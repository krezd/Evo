package com.evolenta.task.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Entity
public class Message {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String text;
    private LocalDateTime time;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Person person;

    public Message() {
    }
    public Message(int id, String title, String text, LocalDateTime time, Person person) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.time = time;
        this.person = person;
    }
    public Message(int id, String title, String text, LocalDateTime time) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.time = time;
    }
    public Message(String title, String text, LocalDateTime time, Person person ) {
        this.title = title;
        this.text = text;
        this.time = time;
        this.person = person;
    }
    public Message(String title, String text) {
        this.title = title;
        this.text = text;
    }
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
