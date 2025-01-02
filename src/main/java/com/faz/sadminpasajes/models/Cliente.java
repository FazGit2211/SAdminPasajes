package com.faz.sadminpasajes.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Cliente extends Persona {
    @OneToOne
    private Pasaje pasaje;
}
