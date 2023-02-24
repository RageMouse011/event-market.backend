package kz.dar.tech.eventloadingservice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import kz.dar.tech.eventloadingservice.util.CategorySerializer;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventDTO {
    private Long id;
    private String title;
    private String description;
    private String location;
    @JsonSerialize(using = CategorySerializer.class)
    private Category category;
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private String date;
    @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING)
    private String time;
}
