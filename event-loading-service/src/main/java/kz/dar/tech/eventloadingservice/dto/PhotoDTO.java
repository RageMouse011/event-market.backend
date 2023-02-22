package kz.dar.tech.eventloadingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PhotoDTO {
    private String name;
    private byte[] data;
    private String eventId;
}
