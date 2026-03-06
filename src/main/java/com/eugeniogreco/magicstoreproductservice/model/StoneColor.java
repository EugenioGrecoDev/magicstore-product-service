package com.eugeniogreco.magicstoreproductservice.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StoneColor {
    BLK("Black"),
    GRY("Gray"),
    WHT("White"),
    YLW("Yellow"),
    BLU("Blue"),
    RED("Red"),
    GRN("Green"),
    ORN("Orange"),
    BRN("Brown"),
    PNK("Pink"),
    PUR("Purple");
    
    private final String label;
}
