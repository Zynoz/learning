package com.zynoz.entities;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Entity(name = "reminder")
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private java.sql.Date date;
    private java.sql.Date reminderdate;
    private boolean everyyear;
    private java.sql.Date datecreated;

    @PrePersist
    private void init() {
      datecreated = Date.valueOf(LocalDate.now());
    }

    public long getId() {
      return id;
    }

    public void setId(long id) {
      this.id = id;
    }


    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }


    public java.sql.Date getBirthdaydate() {
      return date;
    }

    public void setBirthdaydate(java.sql.Date birthdaydate) {
      this.date = birthdaydate;
    }


    public java.sql.Date getReminderdate() {
      return reminderdate;
    }

    public void setReminderdate(java.sql.Date reminderdate) {
      this.reminderdate = reminderdate;
    }

    public boolean getEveryyear() {
      return everyyear;
    }

    public void setEveryyear(boolean everyyear) {
      this.everyyear = everyyear;
    }

    public java.sql.Date getDatecreated() {
      return datecreated;
    }

    public void setDatecreated(java.sql.Date datecreated) {
      this.datecreated = datecreated;
    }

    @Override
    public String toString() {
      return "Reminder{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", birthdaydate=" + date +
              ", reminderdate=" + reminderdate +
              ", everyyear=" + everyyear +
              ", datecreated=" + datecreated +
              '}';
    }
}
