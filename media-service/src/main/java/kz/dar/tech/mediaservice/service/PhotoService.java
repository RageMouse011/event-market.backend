package kz.dar.tech.mediaservice.service;

import kz.dar.tech.mediaservice.entity.Photo;
import kz.dar.tech.mediaservice.repository.PhotoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class PhotoService {

    private final PhotoRepository photoRepository;

    public Photo uploadPhoto(
            MultipartFile file
    ) throws IOException {
        Photo photo = new Photo();
        photo.setData(file.getBytes());
        return photoRepository.save(photo);
    }
    public byte[] downloadPhoto(
            Long id
    ) {
        Photo photo = photoRepository.findById(id).get();
        return photo.getData();
    }

    public void updatePhoto(
            Long id,
            MultipartFile file
    ) throws IOException {
        Photo photo = photoRepository.findById(id).get();
        photo.setData(file.getBytes());
        photoRepository.save(photo);
    }

    public void removePhoto(
            Long id
    ) {
        photoRepository.deleteById(id);
    }
}
