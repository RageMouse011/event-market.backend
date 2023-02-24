package kz.dar.tech.eventloadingservice.service;

import kz.dar.tech.eventloadingservice.dto.EventDTO;
import kz.dar.tech.eventloadingservice.dto.PhotoDTO;
import kz.dar.tech.eventloadingservice.feign.EventClient;
import kz.dar.tech.eventloadingservice.feign.MediaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
@RequiredArgsConstructor
public class EventLoadingService {

    private final EventClient eventClient;
    private final MediaClient mediaClient;


    public void loadEducationalEvent(
            EventDTO eventDTO,
            PhotoDTO photoDTO,
            MultipartFile file
    ) throws IOException {
        EventDTO event = eventClient.postEducationalEvent(eventDTO);
        photoDTO.setEventId(event.getId());
        mediaClient.uploadPhoto(photoDTO, file);
    }
}
