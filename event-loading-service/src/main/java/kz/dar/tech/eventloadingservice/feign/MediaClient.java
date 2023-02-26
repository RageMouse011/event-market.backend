package kz.dar.tech.eventloadingservice.feign;

import kz.dar.tech.eventloadingservice.dto.PhotoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@FeignClient("media-service")
public interface MediaClient {

    @PostMapping(value ="/photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    PhotoDTO uploadPhoto(
        @RequestPart("file") MultipartFile file
    ) throws IOException;
}
