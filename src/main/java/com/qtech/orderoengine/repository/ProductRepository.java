package com.qtech.orderoengine.repository;

import com.qtech.orderoengine.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    @Override
    Optional<ProductEntity> findById(Integer integer);

    @Override
    <S extends ProductEntity> S saveAndFlush(S s);
}
