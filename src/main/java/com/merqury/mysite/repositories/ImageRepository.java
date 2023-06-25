package com.merqury.mysite.repositories;

import com.merqury.mysite.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}
