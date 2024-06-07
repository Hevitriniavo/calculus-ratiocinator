package com.fresh.coding;

import com.fresh.coding.enums.ValeurDeVerite;
import lombok.Getter;

@Getter
public class SimpleAffirmation extends Affirmation {
    private final ValeurDeVerite valeurDeVerite;

    public SimpleAffirmation(String description, ValeurDeVerite valeurDeVerite) {
        super(description);
        this.valeurDeVerite = valeurDeVerite;
    }

    @Override
    public ValeurDeVerite evaluer() {
        return valeurDeVerite;
    }
}
