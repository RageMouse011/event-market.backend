package kz.dar.tech.eventloadingservice.controller;

import kz.dar.tech.eventloadingservice.dto.EventDTO;
import kz.dar.tech.eventloadingservice.dto.PhotoDTO;
import kz.dar.tech.eventloadingservice.service.EventLoadingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventLoadingController {
    private final EventLoadingService eventLoadingService;

    @PostMapping
    public void postEvent(
            @RequestPart("event") EventDTO eventDTO,
            @RequestPart("photo") PhotoDTO photoDTO,
            @RequestPart("file") MultipartFile file
            ) throws IOException {
        eventLoadingService.postEvent(eventDTO, photoDTO, file);
    }

//    @PutMapping("/{id}")
//    public void updateEvent(
//            @PathVariable("id") Long id,
//            @RequestPart("event")
//    )

}
