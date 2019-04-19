package com.zynoz.entity;

import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
public class Birthday {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Name must be set")
    private String name;
    @NotNull(message = "Birthday date must be set")
    @FutureOrPresent(message = "Birthday must be in present or future")
    private LocalDate birthdayDate;
    @FutureOrPresent(message = "Reminder must be in present or future")
    private LocalDate reminderDate;
    @NotNull
    private boolean everyYear;

    @PrePersist
    private void init() {
    }

    public Birthday() {
    }

    public Birthday(String name, LocalDate birthdayDate, LocalDate reminderDate, boolean everyYear) {
        this.name = name;
        this.birthdayDate = birthdayDate;
        this.reminderDate = reminderDate;
        this.everyYear = everyYear;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String content) {
        this.name = content;
    }

    public LocalDate getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(LocalDate dateCreated) {
        this.birthdayDate = dateCreated;
    }

    public LocalDate getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(LocalDate dueDate) {
        this.reminderDate = dueDate;
    }

    public boolean isEveryYear() {
        return everyYear;
    }

    public void setEveryYear(boolean everyYear) {
        this.everyYear = everyYear;
    }

    @Override
    public String toString() {
        return "Birthday{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdayDate=" + birthdayDate +
                ", reminderDate=" + reminderDate +
                ", everyYear=" + everyYear +
                '}';
    }
}