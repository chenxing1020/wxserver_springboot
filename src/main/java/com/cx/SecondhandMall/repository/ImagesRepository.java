package com.cx.SecondhandMall.repository;

import com.cx.SecondhandMall.model.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesRepository extends JpaRepository<Images, String> {
}
