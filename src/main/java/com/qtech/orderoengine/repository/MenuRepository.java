package com.qtech.orderoengine.repository;

import com.qtech.orderoengine.model.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Integer> {
    @Override
    Optional<MenuEntity> findById(Integer integer);

    @Override
    <S extends MenuEntity> S saveAndFlush(S s);
}
