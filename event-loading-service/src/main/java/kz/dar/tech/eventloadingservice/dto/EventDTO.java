package kz.dar.tech.eventloadingservice.dto;

import lombok.*;

import java.sql.Time;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventDTO {
    private String id;
    private String title;
    private String description;
    private String location;
    private Category category;
    private Date date;
    private Time time;
}
