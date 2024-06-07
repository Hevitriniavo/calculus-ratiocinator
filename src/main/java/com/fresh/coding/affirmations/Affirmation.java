package com.fresh.coding.affirmations;

import com.fresh.coding.verites.ValeurDeVerite;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
public abstract class Affirmation {
    private final String description;

    public abstract ValeurDeVerite evaluer();
}
