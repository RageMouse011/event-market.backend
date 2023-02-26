package kz.dar.tech.eventservice.dto;

import kz.dar.tech.eventservice.category.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EventDTO {
    private Long id;
    private String title;
    private String description;
    private String location;
    private Category category;
    private Long photoId;
    private String date;
    private String time;
}
