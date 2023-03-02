package kz.dar.tech.eventservice.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import kz.dar.tech.eventservice.category.Category;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "events")
@ToString
public class Event {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "location", nullable = false)
    private String location;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false)
    private Category category;

    @Column(name = "photo_id")
    private Long photoId;

    @Column(name = "date", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private String date;

    @Column(name = "time", nullable = false)
    @JsonFormat(pattern = "HH:mm", shape = JsonFormat.Shape.STRING)
    private String time;

}
