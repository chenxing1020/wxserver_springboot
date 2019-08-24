package com.cx.SecondhandMall.repository;

import com.cx.SecondhandMall.model.Favors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavorsRepository extends JpaRepository<Favors, String> {
}
