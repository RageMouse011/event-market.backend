package kz.dar.tech.mediaservice.controller;

import kz.dar.tech.mediaservice.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/photos")
public class PhotoController {

    private final PhotoService photoService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadPhoto(
            @RequestParam("image") MultipartFile file
    ) {
        return photoService.uploadPhoto(file);
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> downloadPhoto(
            @PathVariable Long id
    ) {
        return photoService.downloadPhoto(id);

    }
}
