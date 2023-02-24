package kz.dar.tech.eventloadingservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import kz.dar.tech.eventloadingservice.dto.Category;
import kz.dar.tech.eventloadingservice.dto.EventDTO;
import kz.dar.tech.eventloadingservice.dto.PhotoDTO;
import kz.dar.tech.eventloadingservice.feign.EventClient;
import kz.dar.tech.eventloadingservice.feign.MediaClient;
import kz.dar.tech.eventloadingservice.util.CategorySerializer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
@RequiredArgsConstructor
public class EventLoadingService {

    private final EventClient eventClient;
    private final MediaClient mediaClient;


    public void postEvent(
            EventDTO eventDTO,
            PhotoDTO photoDTO,
            MultipartFile file
    ) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Category.class, new CategorySerializer());
        objectMapper.registerModule(module);

        String eventJson = objectMapper.writeValueAsString(eventDTO);
        EventDTO event = eventClient.postEvent(eventJson);

        photoDTO.setEventId(event.getId());
        mediaClient.uploadPhoto(photoDTO, file);
    }
}
