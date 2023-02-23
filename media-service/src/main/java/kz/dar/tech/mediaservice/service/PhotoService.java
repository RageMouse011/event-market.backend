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

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;

    public String uploadPhoto(
            MultipartFile file
    ) {
        try {
            Photo photo = new Photo(file.getOriginalFilename(), file.getBytes());
            photoRepository.save(photo);
            return file.getOriginalFilename();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public byte[] downloadPhoto(
            Long id
    ) {
        Photo photo = photoRepository.findById(id).get();
        return photo.getData();
    }
}
