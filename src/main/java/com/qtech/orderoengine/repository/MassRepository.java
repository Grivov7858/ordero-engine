package com.qtech.orderoengine.repository;

import com.qtech.orderoengine.model.entity.MassEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MassRepository extends JpaRepository<MassEntity, Integer> {
    @Override
    Optional<MassEntity> findById(Integer integer);

    @Override
    <S extends MassEntity> S saveAndFlush(S s);
}
