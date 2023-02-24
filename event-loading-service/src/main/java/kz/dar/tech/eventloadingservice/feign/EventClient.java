package kz.dar.tech.eventloadingservice.feign;

import kz.dar.tech.eventloadingservice.dto.EventDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;

@FeignClient("event-service")
public interface EventClient {

    @PostMapping(value = "/event", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    EventDTO postEvent(
            @RequestPart String eventJson
    );
}
