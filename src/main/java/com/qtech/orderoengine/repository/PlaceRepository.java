package com.qtech.orderoengine.repository;

import com.qtech.orderoengine.model.entity.PlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceRepository extends JpaRepository<PlaceEntity, Integer> {
    @Override
    Optional<PlaceEntity> findById(Integer integer);

    @Override
    <S extends PlaceEntity> S saveAndFlush(S s);
}
