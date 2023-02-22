package kz.dar.tech.eventloadingservice.feign;

import kz.dar.tech.eventloadingservice.dto.EventDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("event-service")
public interface EventClient {

    @PostMapping(value = "/events/post/educational", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    EventDTO postEducationalEvent(
            @RequestBody EventDTO eventDTO
    );
}
