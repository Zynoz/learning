package com.airhacks.entity;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Todo must be set")
    private String content;
    private LocalDate dateCreated;
    @NotNull(message = "Duedate must be set")
    @FutureOrPresent(message = "Duedate must be in present or future")
    private LocalDate dueDate;
    private boolean isCompleted;

    @PrePersist
    private void init() {
     setDateCreated(LocalDate.now());
    }

    public Todo() {

    }

    public Todo(String content, LocalDate dateCreated, LocalDate dueDate, boolean isCompleted) {
        this.content = content;
        this.dateCreated = dateCreated;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        this.isCompleted = completed;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", dateCreated=" + dateCreated +
                ", dueDate=" + dueDate +
                ", isCompleted=" + isCompleted +
                '}';
    }
}