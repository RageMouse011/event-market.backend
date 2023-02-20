package kz.dar.tech.mediaservice.repository;

import kz.dar.tech.mediaservice.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoRepository
        extends JpaRepository<Photo, Long> {
}
