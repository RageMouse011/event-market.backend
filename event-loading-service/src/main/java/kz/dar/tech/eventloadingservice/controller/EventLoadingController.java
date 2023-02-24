package kz.dar.tech.eventloadingservice.controller;

import kz.dar.tech.eventloadingservice.dto.EventDTO;
import kz.dar.tech.eventloadingservice.dto.PhotoDTO;
import kz.dar.tech.eventloadingservice.feign.MediaClient;
import kz.dar.tech.eventloadingservice.service.EventLoadingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequiredArgsConstructor
@RequestMapping("/manage")
public class EventLoadingController {
    private final EventLoadingService eventLoadingService;
    private final MediaClient mediaClient;

    @PostMapping("/load")
    public void loadEducationalEvent(
            @RequestPart("event") EventDTO eventDTO,
            @RequestPart("photo") PhotoDTO photoDTO,
            @RequestPart("file") MultipartFile file
            ) throws IOException {
        eventLoadingService.loadEducationalEvent(eventDTO, photoDTO, file);
    }

    @PostMapping(value = "/test", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void test(
            @RequestPart("photo") PhotoDTO photoDTO,
            @RequestPart("file") MultipartFile file
    ) throws IOException {
        mediaClient.uploadPhoto(photoDTO, file);
    }

}
