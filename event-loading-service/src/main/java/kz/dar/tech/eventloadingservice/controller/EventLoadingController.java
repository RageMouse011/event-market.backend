package kz.dar.tech.eventloadingservice.controller;

import kz.dar.tech.eventloadingservice.dto.EventDTO;
import kz.dar.tech.eventloadingservice.service.EventLoadingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequiredArgsConstructor
@RequestMapping("/manage")
public class EventLoadingController {
    private final EventLoadingService eventLoadingService;

    @PostMapping(value = "/load")
    public ResponseEntity<String> loadEducationalEvent(
            @RequestPart("event") EventDTO eventDTO,
            @RequestPart("photo") MultipartFile file
    ) {
        return eventLoadingService.loadEducationalEvent(eventDTO, file);
    }

}
