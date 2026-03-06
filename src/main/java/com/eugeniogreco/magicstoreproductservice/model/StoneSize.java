package com.eugeniogreco.magicstoreproductservice.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StoneSize {
    SML("Small"),
    MED("Medium"),
    LRG("Large");

    private final String label;
}
