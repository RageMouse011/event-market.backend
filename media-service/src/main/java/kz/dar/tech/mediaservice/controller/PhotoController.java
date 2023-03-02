package kz.dar.tech.mediaservice.controller;

import kz.dar.tech.mediaservice.entity.Photo;
import kz.dar.tech.mediaservice.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/photo")
public class PhotoController {

    private final PhotoService photoService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Photo uploadPhoto(
             MultipartFile file
    ) throws IOException {
        return photoService.uploadPhoto(file);
    }

    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] downloadPhoto(
            @PathVariable Long id
    ) {
        return photoService.downloadPhoto(id);
    }

    @PutMapping("/{id}")
    public void updatePhoto(
            @PathVariable(name = "id") Long id,
            @RequestParam("file") MultipartFile file
    ) throws IOException {
        photoService.updatePhoto(id, file);
    }

    @DeleteMapping("/{id}")
    public void removePhoto(
            @PathVariable Long id
    ) {
        photoService.removePhoto(id);
    }
}
