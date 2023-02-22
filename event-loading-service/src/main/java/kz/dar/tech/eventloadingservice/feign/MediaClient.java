package kz.dar.tech.eventloadingservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@FeignClient("media-service")
public interface MediaClient {

    @PostMapping(value ="/photos/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResponseEntity<String> uploadPhoto(
        @RequestParam(name = "image") MultipartFile file,
        String eventId
    );
}
