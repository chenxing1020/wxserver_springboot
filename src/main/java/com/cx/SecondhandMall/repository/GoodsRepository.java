package com.cx.SecondhandMall.repository;

import com.cx.SecondhandMall.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, String> {
}
