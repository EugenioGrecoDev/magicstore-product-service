package com.eugeniogreco.magicstoreproductservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

import com.eugeniogreco.magicstoreproductservice.model.MagicStone;
import com.eugeniogreco.magicstoreproductservice.repository.MagicStoneRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class MagicStoneServiceImpl implements MagicStoneService {

    private final MagicStoneRepository repository;

    @Override
    public MagicStone create(MagicStone stone) {

        String serial = generateSerialNumber(stone);

        stone.setSerialNumber(serial);

        return repository.save(stone);
    }

    @Override
    public MagicStone update(Long id, MagicStone updated) {
        MagicStone existing = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("MagicStone not found"));

        // Il serial number NON cambia mai
        existing.setName(updated.getName());
        existing.setColor(updated.getColor());
        existing.setSize(updated.getSize());
        existing.setDescription(updated.getDescription());

        return repository.save(existing);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("MagicStone not found");
        }
        repository.deleteById(id);
    }

    @Override
    public MagicStone findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("MagicStone not found"));
    }

    @Override
    public List<MagicStone> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean existsBySerialNumber(String serialNumber) {
        return repository.existsBySerialNumber(serialNumber);
    }

    // ---------------------------------------------------------
    // SERIAL NUMBER GENERATION: COL-SIZ-UUID + retry if exists
    // ---------------------------------------------------------

    private String generateSerialNumber(MagicStone stone) {
        String color = stone.getColor().name();
        String size = stone.getSize().name();

        String serial;

        do {
            String uuid = UUID.randomUUID().toString().substring(0, 5).toUpperCase();
            serial = color + "-" + size + "-" + uuid;
        } while (repository.existsBySerialNumber(serial));

        return serial;
    }
}