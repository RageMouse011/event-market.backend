package kz.dar.tech.eventservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import kz.dar.tech.eventservice.entity.Event;
import kz.dar.tech.eventservice.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    @GetMapping("/all")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Event getEvent(
            @PathVariable(name = "id") Long id
    ) {
        return eventService.getEvent(
                id
        );
    }

    @GetMapping("/sports")
    public List<Event> getSportsEvents() {
        return eventService.getSportsEvents();
    }

    @GetMapping("/educational")
    public List<Event> getEducationalEvents() {
        return eventService.getEducationalEvents();
    }

    @GetMapping("/entertaining")
    public List<Event> getEntertainingEvents() {
        return eventService.getEntertainingEvents();
    }


    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Event postEvent(
            String eventJson
    ) throws JsonProcessingException {
        return eventService.postEvent(
                eventJson
        );
    }
    @PutMapping("/{id}")
    public Event updateEvent(
            @PathVariable(name = "id") Long id,
            @RequestBody Event event
    ) {
        return eventService.updateEvent(
                id,
                event
        );
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(
            @PathVariable(name = "id") Long id
    ) {
        eventService.deleteEvent(
                id
        );
    }
}
