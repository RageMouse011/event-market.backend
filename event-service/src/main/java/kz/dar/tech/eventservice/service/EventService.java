package kz.dar.tech.eventservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import kz.dar.tech.eventservice.category.Category;
import kz.dar.tech.eventservice.dto.EventDTO;
import kz.dar.tech.eventservice.entity.Event;
import kz.dar.tech.eventservice.repository.EventRepository;
import kz.dar.tech.eventservice.util.CategoryDeserializer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;
    private final EventProducer eventProducer;


    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEvent(
            Long id
    ) {
        return eventRepository.findById(id).get();
    }

    public List<Event> getSportsEvents() {
        return eventRepository.findEventsByCategory(Category.SPORTS);
    }

    public List<Event> getEducationalEvents() {
        return eventRepository.findEventsByCategory(Category.EDUCATIONAL);
    }

    public List<Event> getEntertainingEvents() {
        return eventRepository.findEventsByCategory(Category.ENTERTAINING);
    }


    public Event postEvent(
            String eventJson
    ) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Category.class, new CategoryDeserializer());
        objectMapper.registerModule(module);

        EventDTO eventDTO = objectMapper.readValue(eventJson, EventDTO.class);
        Event event = Event.builder()
                .title(eventDTO.getTitle())
                .description(eventDTO.getDescription())
                .location(eventDTO.getLocation())
                .category(eventDTO.getCategory())
                .photoId(eventDTO.getPhotoId())
                .date(eventDTO.getDate())
                .time(eventDTO.getTime())
                .build();


        eventRepository.save(
                event
        );
        eventProducer.sendEvent(event, "event-key");
        return event;
    }
    public void removeEvent(
            Long id
    ) {
        eventRepository.deleteById(id);
    }

    public Event updateEvent(
            Long id,
            Event event
    ) {
        Event updatedEvent = eventRepository.findById(id).get();
        updatedEvent.setTitle(event.getTitle());
        updatedEvent.setDescription(event.getDescription());
        updatedEvent.setLocation(event.getLocation());
        updatedEvent.setDate(event.getDate());
        return eventRepository.save(updatedEvent);
    }
}
