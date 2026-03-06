package com.eugeniogreco.magicstoreproductservice.service;

import java.util.List;

import com.eugeniogreco.magicstoreproductservice.model.MagicStone;

public interface MagicStoneService {

    MagicStone create(MagicStone stone);

    MagicStone update(Long id, MagicStone stone);

    void delete(Long id);

    MagicStone findById(Long id);

    List<MagicStone> findAll();

    boolean existsBySerialNumber(String serialNumber);
}
