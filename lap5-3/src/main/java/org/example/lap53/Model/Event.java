package org.example.lap53.Model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Event {
    public int id;
    public String description;
    public int capacity;
    @JsonFormat
    public LocalDateTime startDate;
    @JsonFormat
    public LocalDateTime endDate;

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}