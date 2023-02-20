package kz.dar.tech.eventservice.repository;

import kz.dar.tech.eventservice.category.Category;
import kz.dar.tech.eventservice.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository
        extends JpaRepository<Event, Long> {

    List<Event> findEventsByCategory(Category category);
}
