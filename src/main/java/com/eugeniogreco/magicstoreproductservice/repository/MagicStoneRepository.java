package com.eugeniogreco.magicstoreproductservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eugeniogreco.magicstoreproductservice.model.MagicStone;
import com.eugeniogreco.magicstoreproductservice.model.StoneColor;
import com.eugeniogreco.magicstoreproductservice.model.StoneSize;

@Repository
public interface MagicStoneRepository extends JpaRepository<MagicStone, Long> {
    Optional<MagicStone> findBySerialNumber(String serialNumber);
    boolean existsBySerialNumber(String serialNumber);
    List<MagicStone> findByColor(StoneColor color);
    List<MagicStone> findBySize(StoneSize size);
    List<MagicStone> findByColorAndSize(StoneColor color, StoneSize size);
}
