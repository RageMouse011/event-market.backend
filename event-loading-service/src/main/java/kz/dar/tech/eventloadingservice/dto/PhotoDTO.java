package kz.dar.tech.eventloadingservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhotoDTO {
    private Long id;
    private byte[] data;
}
