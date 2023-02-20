package kz.dar.tech.mediaservice.service;

import kz.dar.tech.mediaservice.entity.Photo;
import kz.dar.tech.mediaservice.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;

    public ResponseEntity<String> uploadPhoto(
            MultipartFile file
    ) {
        try {
            Photo photo = new Photo(file.getOriginalFilename(), file.getBytes());
            photoRepository.save(photo);
            return ResponseEntity.ok("Photo uploaded successfully : " + file.getOriginalFilename());
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload photo");
        }
    }
    public ResponseEntity<byte[]> downloadPhoto(
            Long id
    ) {
        Optional<Photo> photo = photoRepository.findById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return photo.map(value -> new ResponseEntity<>(value.getData(), headers, HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
