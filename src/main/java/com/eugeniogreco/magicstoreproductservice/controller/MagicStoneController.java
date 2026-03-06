package com.eugeniogreco.magicstoreproductservice.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eugeniogreco.magicstoreproductservice.model.MagicStone;
import com.eugeniogreco.magicstoreproductservice.service.MagicStoneService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/stones")
@RequiredArgsConstructor
public class MagicStoneController {

    private final MagicStoneService service;

    // CREATE
    @PostMapping
    public ResponseEntity<MagicStone> create(@Valid @RequestBody MagicStone stone) {
        MagicStone created = service.create(stone);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    // READ ALL
    @GetMapping
    public List<MagicStone> findAll() {
        return service.findAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public MagicStone findById(@PathVariable Long id) {
        return service.findById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public MagicStone update(
            @PathVariable Long id,
            @Valid @RequestBody MagicStone stone
    ) {
        return service.update(id, stone);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
