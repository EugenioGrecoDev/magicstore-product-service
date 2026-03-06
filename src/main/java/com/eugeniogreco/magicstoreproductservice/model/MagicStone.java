package com.eugeniogreco.magicstoreproductservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MagicStone {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Size(max= 20)
    @Column(nullable= false, unique=true, length= 20)
    private String serialNumber;

    @NotBlank(message= "name is required")
    @Size(max= 50, message= "name must be at most 50 characters")
    @Column(nullable= false)
    private String name;

    @NotBlank(message= "description is required")
    @Size(max= 255, message = "description must be at most 255 characters")
    @Column(nullable= false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable= false, length= 3)
    private StoneColor color;

    @Enumerated(EnumType.STRING)
    @Column(nullable= false, length= 3)
    private StoneSize size;
}
