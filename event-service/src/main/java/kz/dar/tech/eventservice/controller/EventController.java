package kz.dar.tech.eventservice.controller;

import kz.dar.tech.eventservice.entity.Event;
import kz.dar.tech.eventservice.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;

    @GetMapping("/all")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    public Event getEvent(
            @PathVariable(name = "id") String id
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

    @PostMapping("/post/sports")
    public Event postSportsEvent(
            @RequestBody Event event
    ) {
        return eventService.postSportsEvent(
                event
        );
    }

    @PostMapping(value = "/post/educational", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Event postEducationalEvent(
            Event event
    ) {
        return eventService.postEducationalEvent(
                event
        );
    }

    @PostMapping("/post/entertaining")
    public Event postEntertainingEvent(
            @RequestBody Event event
    ) {
        return eventService.postEntertainingEvent(
                event
        );
    }

    @PutMapping("/update/{id}")
    public Event updateEvent(
            @PathVariable(name = "id") String id,
            @RequestBody Event event
    ) {
        return eventService.updateEvent(
                id,
                event
        );
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEvent(
            @PathVariable(name = "id") String id
    ) {
        eventService.deleteEvent(
                id
        );
    }
}
