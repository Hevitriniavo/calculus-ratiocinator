package com.fresh.coding;

import com.fresh.coding.enums.ValeurDeVerite;
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
