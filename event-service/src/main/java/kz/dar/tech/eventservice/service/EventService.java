package kz.dar.tech.eventservice.service;

import kz.dar.tech.eventservice.category.Category;
import kz.dar.tech.eventservice.entity.Event;
import kz.dar.tech.eventservice.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventRepository eventRepository;


    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEvent(
            String id
    ) {
        return eventRepository.findById(id);
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

    public Event postSportsEvent(
            Event event
    ) {
        event.setCategory(Category.SPORTS);
        return eventRepository.save(
                event
        );
    }

    public Event postEducationalEvent(
            Event event
    ) {
        event.setCategory(Category.EDUCATIONAL);
        return eventRepository.save(
                event
        );
    }

    public Event postEntertainingEvent(
            Event event
    ) {
        event.setCategory(Category.ENTERTAINING);
        return eventRepository.save(
                event
        );
    }

    public void deleteEvent(
            String id
    ) {
        eventRepository.deleteById(id);
    }

    public Event updateEvent(
            String id,
            Event event
    ) {
        Event updatedEvent = eventRepository.findById(id);
        updatedEvent.setTitle(event.getTitle());
        updatedEvent.setDescription(event.getDescription());
        updatedEvent.setLocation(event.getLocation());
        updatedEvent.setDate(event.getDate());
        updatedEvent.setTime(event.getTime());
        return eventRepository.save(updatedEvent);
    }
}
