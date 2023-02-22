package kz.dar.tech.eventloadingservice.service;

import kz.dar.tech.eventloadingservice.dto.EventDTO;
import kz.dar.tech.eventloadingservice.feign.EventClient;
import kz.dar.tech.eventloadingservice.feign.MediaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class EventLoadingService {

    private final EventClient eventClient;
    private final MediaClient mediaClient;


    public ResponseEntity<String> loadEducationalEvent(
            EventDTO eventDTO,
            MultipartFile file
    ) {
        eventDTO.setId(UUID.randomUUID().toString());
        eventClient.postEducationalEvent(eventDTO);
        return mediaClient.uploadPhoto(file, eventDTO.getId());
    }
}
