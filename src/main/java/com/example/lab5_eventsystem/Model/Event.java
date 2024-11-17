package com.example.lab5_eventsystem.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class Event {

    private int ID;
    private String description;
    private int capacity;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd 'T' hh:mm")
    private LocalDateTime startDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd 'T' hh:mm")
    private LocalDateTime endDate;

}
